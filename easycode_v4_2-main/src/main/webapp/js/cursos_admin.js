$(document).ready(function() {  
    $('#editor').summernote({
		disableGrammar: false,
		lang: 'es-ES',
		spellCheck: false,
		height: 300,
		placeholder: 'Contenido del curso',
		toolbar: [
            ['style', ['style']],
			['style', ['bold', 'italic', 'underline', 'clear']],
			['font', ['strikethrough', 'superscript', 'subscript']],
			['color', ['color']],
			['para', ['ul', 'ol', 'paragraph']]
		],
		callbacks: {
			onPaste: function (e) {
				var bufferText = ((e.originalEvent || e).clipboardData || window.clipboardData).getData('Text');
				e.preventDefault();
				document.execCommand('insertText', false, bufferText);
			}
		}
	});
    
    $('#form_nuevo').on('submit', function(e) {
        e.preventDefault();
        
        $.ajax({
			'url' : base_url + 'agregar_curso',
			'type' : 'post',
			'data' : { 
                nombre : $('#nombre').val(),
                costo : $('#costo').val(),
                categoria : $('#categoria').val(),
                texto : $('#editor').summernote('code'),
                descripcion : $('#descripcion').val(),
            },
			'success' : function(obj){
				if(obj['resultado']){
					Swal.fire(
                        'Curso añadido',
                        'El curso ha sido añadido con éxito',
                        'success'
                      );
                    $('#modal_agregar').modal('hide');
                    $('#form_nuevo').trigger('reset');
                    $('#editor').summernote('code', '');
                    cargarCursos();
				}
                else{
					Swal.fire(
                        'No se pudo añadir el curso',
                        'Vuelve a intentar enviar el curso',
                        'error'
                      );
				}
			}
		});
    });
    
    cargarCursos();
});

function cargarCursos() {
    $.ajax({
        'url' : base_url + 'obtener_cursos',
        'type' : 'post',
        'success' : function(obj){
            if(obj['resultado']){
                var contenidoTabla = "";
                
                $.each(obj['cursos'], function(i, elemento) {
                    contenidoTabla += 
                        '<tr>' +
                            '<td>' + elemento.id_curso + '</td>' +
                            '<td>' + elemento.nombre + '</td>' +
                            '<td>' + elemento.descripcion + '</td>' +
                            '<td>' + elemento.categoria + '</td>' +
                            '<td>' + elemento.costo + '</td>' +
                            '<td><button class="btn btn-danger" onclick="borrarCurso(' + elemento.id_curso + ')">Eliminar</button></td>' +
                        '</tr>';
                });
                
                $('#tabla_cursos tbody').html(contenidoTabla);
            }
            else{
                var contenidoTabla = '<tr><td colspan="5">No hay cursos registrados</td></tr>';
                
                $('#tabla_cursos tbody').html(contenidoTabla);
            }
        }
    });
}

function borrarCurso(id) {
    Swal.fire({
        icon: 'warning',
        title: '¿Está seguro de eliminar el curso?',
        showCancelButton: true,
        confirmButtonText: 'Aceptar',
		cancelButtonText: 'Cancelar',
    }).then((result) => {
        if(result.value) {
            $.ajax({
                'url' : base_url + 'borrar_curso',
                'type' : 'post',
                'data' : {
                    'id_curso' : id
                },
                'success' : function(obj){
                    if(obj['resultado']){
                        Swal.fire({
                            icon: 'success',
                            title: '¡Se ha eliminado con exito!',
                        });
                        cargarCursos();
                    }
                    else{
                        Swal.fire({
                            icon: 'error',
                            title: 'No se pudo eliminar.',
                        });
                    }
                }
            });
        }
    });
}