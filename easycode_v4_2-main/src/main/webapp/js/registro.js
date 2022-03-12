$(document).ready(function() {
    $("#registro").validate({
        rules: {
            nombre: { required: true, minlength: 2},
            apellidos: { required: true, minlength: 2},
            correo: { required:true, email: true},
            password: { required:true, minlength: 8}
        },

        messages: {
            nombre: "El nombre es obligatorio",
            apellidos: "El apellido es obligatorio",
            correo : {
                required:"El correo es obligatorio", 
                email: "El formato es nombre@dominio.algo"
            },
            password: {
                required:"La contraseña es obligatoria", 
                minlength: "La contraseña debe tener al menos 8 letras"
            }               
        }
    });
});