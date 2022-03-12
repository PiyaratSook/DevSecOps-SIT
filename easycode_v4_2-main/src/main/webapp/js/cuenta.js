$(document).ready(function() {
    $("#datos_cuentas").validate({
        rules: {
            nombre: {
                required: true,
            },
            apellidos: {
                required: true,
            },
            correo: { 
                required:true, 
                email: true
            },
            contra_nueva: {
                minlength: 8
            },
            confirmar_contra_nueva: {
                equalTo: "#contra_nueva"
            }
        },

        messages: {
            nombre: {
                required: "Se requiere el nombre"
            },
            apellidos: {
                required: "Se requieren los apellidos"
            },
            correo: { 
                required: "Se requiere un correo", 
                email: "Se requiere un correo válido"
            },
            contra_nueva: {
                minlength: "La nueva contraseña debe tener al menos 8 caracteres"
            },
            confirmar_contra_nueva: {
                equalTo: "Las contraseñas deben coincidir"
            }
        }
    });
});