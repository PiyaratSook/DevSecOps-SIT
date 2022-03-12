$(document).ready(function() {
var availableTags = [
      "CodeIgniter",
      "PHP",
      "MySQL",
      "Java",
      "C++",
      "Precio de los cursos",
      "Precio de subscripción",
      "Datos de cuenta"
    ];
    
    $( "#buscador" ).autocomplete({
      source: availableTags,
      appendTo: "#caja"
    });
});