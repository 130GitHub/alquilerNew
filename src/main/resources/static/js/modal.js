// Obtiene la ventana modal y el botón para cerrarla
var modal = document.getElementById("miModal");
var span = document.getElementsByClassName("close")[0];

// Función para abrir la ventana modal
function abrirModal() {
  modal.style.display = "block";
}

// Función para cerrar la ventana modal
function cerrarModal() {
  modal.style.display = "none";
}

// Cierra la ventana modal si se hace clic fuera de ella
window.onclick = function(event) {
  if (event.target == modal) {
    modal.style.display = "none";
  }
}