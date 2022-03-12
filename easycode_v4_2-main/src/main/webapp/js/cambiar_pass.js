$(document).ready(function() {
    $("#cambiar_pass").validate({
        rules: {
            nuevoPassword: {
                required: true,
                minlength: 9
            },
            nuevoPasswordConfirmar: {
                required: true,
                equalTo: "#nuevoPassword"
            }
        },

        messages: {
            nuevoPassword: {
                required: "La contraseña es obligatoria", 
                minlength: "La contraseña debe tener al menos 8 letras", 
            },
            nuevoPasswordConfirmar: {
                required: "La contraseña es obligatoria", 
                equalTo: "Las contraseñas debe coincidir"      
            }
        }
    });
});