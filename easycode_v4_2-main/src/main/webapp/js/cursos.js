$(document).ready(function() {
    cargarCursos();
    
    $("#buscador_cursos").keyup(function() {
        var buscar = $(this).val();
        if(buscar.length > 2) {
            $.ajax({
                'url' : base_url + 'buscar_cursos',
                'type' : 'post',
                'data' : {
                    'buscar' : buscar
                },
                'success' : function(obj){
                    console.log(obj);
                    if(obj['resultado']){
                        var contenidoCursos = "";

                        $.each(obj['cursos'], function(i, elemento) {
                            contenidoCursos += 
                                '<div class="col-3 d-flex justify-content-center">' +
                                    '<div class="card" style="width: 18rem;">' +
                                        '<div class="card-body d-flex flex-column">' +
                                            '<h5 class="card-title">' + elemento.nombre + '</h5>' +
                                            '<h6 class="card-subtitle mb-2 text-muted">Plataforma: ' + elemento.categoria + '</h6>' +
                                            '<p class="card-text">' + elemento.descripcion + '</p>' +
                                            '<hr class="w-100 mt-auto">' +
                                            '<div class="row">' +
                                                '<div class="col-6">' +
                                                    '<h4>$' + elemento.costo + '</h4>' +
                                                '</div>' +
                                                '<div class="col-6">' +
                                                    '<button class="btn btn-success btn-block" data-toggle="tooltip" data-placement="top" title="¡Envío gratis!" onclick="comprarCurso(' + elemento.id_curso + ')">Comprar</button>' +
                                                '</div>' +
                                            '</div>' +
                                        '</div>' +
                                    '</div>' +
                                '</div>';
                        });

                        $('#lista_cursos').html(contenidoCursos);
                        $(function () {
                            $('[data-toggle="tooltip"]').tooltip();
                        });
                    }
                    else{
                        var contenidoCursos = 
                                '<div class="col-12 text-center">' +
                                   '<h3>No se encontraron cursos</h3>' +
                                '</div>';

                        $('#lista_cursos').html(contenidoCursos);
                    }
                }
            });
        }
        else {
            cargarCursos();
        }
    })
});

function cargarCursos() {
    $.ajax({
        'url' : base_url + 'obtener_cursos',
        'type' : 'post',
        'success' : function(obj){
            console.log(obj);
            if(obj['resultado']){
                var contenidoCursos = "";
                
                $.each(obj['cursos'], function(i, elemento) {
                    contenidoCursos += 
                        '<div class="col-3 d-flex justify-content-center">' +
                            '<div class="card" style="width: 18rem;">' +
                                '<div class="card-body d-flex flex-column">' +
                                    '<h5 class="card-title">' + elemento.nombre + '</h5>' +
                                    '<h6 class="card-subtitle mb-2 text-muted">Plataforma: ' + elemento.categoria + '</h6>' +
                                    '<p class="card-text">' + elemento.descripcion + '</p>' +
                                    '<hr class="w-100 mt-auto">' +
                                    '<div class="row">' +
                                        '<div class="col-6">' +
                                            '<h4>$' + elemento.costo + '</h4>' +
                                        '</div>' +
                                        '<div class="col-6">' +
                                            '<button class="btn btn-success btn-block" data-toggle="tooltip" data-placement="top" title="¡Envío gratis!" onclick="comprarCurso(' + elemento.id_curso + ')">Comprar</button>' +
                                        '</div>' +
                                    '</div>' +
                                '</div>' +
                            '</div>' +
                        '</div>';
                });
                
                $('#lista_cursos').html(contenidoCursos);
                $(function () {
                    $('[data-toggle="tooltip"]').tooltip();
                });
            }
            else{
                var contenidoCursos = 
                        '<div class="col-12 text-center">' +
                           '<h3>No hay cursos registrados</h3>' +
                        '</div>';
                
                $('#lista_cursos').html(contenidoCursos);
            }
        }
    });
}

function comprarCurso(id_curso) {
    $.ajax({
        'url' : base_url + 'obtener_curso',
        'type' : 'post',
        'data' : { 
            id_curso : id_curso
        },
        'success' : function(obj){
            if(obj['resultado']){
                $("#form_tarjeta input").prop("disabled", false);
                var curso = obj['curso'];
                
                $("#resumen_titulo").text(curso.nombre);
                $("#resumen_costo").text('$' + curso.costo);
                $("#resumen_total").text('$' + curso.costo);
                $("#modal_pago").modal('show');
                $("#costo").val(curso.costo);
                
                $("#pagar_curso").off("click");
                $("#pagar_curso").on("click", function() {
                    $("#form_tarjeta input").prop("disabled", true);
                    
                    $.ajax({
                        'url' : base_url + 'comprar_curso',
                        'type' : 'post',
                        data : {
                            id_curso : id_curso
                        },
                        'success' : function(obj){
                            console.log(obj);
                            if(obj['resultado']){
                                $("#progress_bar_div").removeClass('d-none');
                                var current_progress = 0;
                                var step = 10;

                                var interval = setInterval(function() {
                                    current_progress += step;
                                    $("#barra_progreso").css("width", current_progress + "%").attr("aria-valuenow", current_progress);
                                    if (current_progress >= 100){
                                        clearInterval(interval);
                                        Swal.fire(
                                            '¡Curso comprado!',
                                            'Ya puedes visualizar el curso',
                                            'success'
                                          );
                                        $('#modal_pago').modal('hide');
                                        $("#progress_bar_div").addClass('d-none');
                                        $("#barra_progreso").css("width", "0%");
                                    }else if(current_progress >= 70) {
                                        step = 2;
                                    } else if(current_progress >= 20) {
                                        step = 5;
                                    }
                                }, 100);
                            }
                            else{
                                Swal.fire(
                                    'No se pudo comprar el curso',
                                    'Vuelve a intentar comprar el curso',
                                    'error'
                                );
                            }
                        }
                    });
                });
            }
            else{
                Swal.fire(
                    'No se puede comprar el curso',
                    'Vuelve a intentar comprar el curso',
                    'error'
                  );
            }
        }
    });
}