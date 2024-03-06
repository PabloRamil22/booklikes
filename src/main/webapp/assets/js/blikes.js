function mostrarFormulario(id) {
    // Oculta todos los formularios
    document.querySelectorAll('.tab-content .cont').forEach(form => form.style.display = 'none');

    // Muestra el formulario correspondiente
    document.getElementById(id).style.display = 'block';
}