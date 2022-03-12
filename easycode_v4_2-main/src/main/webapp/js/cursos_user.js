$(document).ready(function() {      
    cargarCursos();
});

function cargarCursos() {
    var contenidoCompras = "";
    $.ajax({
        'url' : base_url + 'cargar_compras',
        'type' : 'post',
        'success' : function(obj){
            console.log(obj);
            if(obj['resultado']){ 
                $.each(obj['ventas'], function(i, elemento) {
                    var venta = elemento.venta;
                    var curso = elemento.curso;
                    
                    contenidoCompras += 
                        '<tr>' +
                            '<td>' + curso.nombre + '</td>' +
                            '<td>' + curso.descripcion + '</td>' +
                            '<td>' + curso.categoria + '</td>' +
                            '<td>' + venta.fecha_venta + '</td>' +
                            '<td>$' + curso.costo + '</td>' +
                            '<td><a href="' + base_url + 'vercurso?id_venta=' + venta.id_venta + '&id_curso=' + curso.id_curso + '" class="btn btn-secondary">Ver curso</a></td>' +
                        '</tr>';
                });
                
                $('#tabla_cursos tbody').html(contenidoCompras);
            }
            else{
                contenidoCompras = 
                        '<tr>' +
                            '<td colspan="6">No hay compras registradas</td>' +
                        '</tr>';
                
                $('#tabla_cursos tbody').html(contenidoCompras);
            }
        }
    });
}