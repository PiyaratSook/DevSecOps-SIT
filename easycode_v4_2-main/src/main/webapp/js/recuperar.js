$(document).ready(function() {
	$.ajaxSetup({
		'error' : function(xhr){
			Swal.fire({
				'icon' : 'error',
				'title' : 'Error en el servidor',
				'html' : '<b>Mensaje técnico:</b><br>' +
						 '<p>' + xhr.status + ' ' + xhr.statusText + '</p>',
				confirmButtonText: 'Aceptar'
			});
		}
	});
	
	$('#form_recuperar').on('submit', function(e) {
		e.preventDefault();
        $('#overlay').fadeIn();

		$.ajax({
			'url' : base_url + 'enviar_recuperacion',
			'type' : 'post',
			'data' : { correo : $('#correo').val() },
			'success' : function(obj){
                console.log(obj);
				if(obj['resultado']){
                    $('#overlay').fadeOut();
					Swal.fire(
                        'Correo enviado',
                        'Revisa tu correo para ver tu contraseña',
                        'success'
                      );
				}
                else{
                    $('#overlay').fadeOut();
					Swal.fire(
                        'No se pudo enviar el correo',
                        'Error: ' + obj['error'],
                        'error'
                      );
				}
			}
		});
	});
});