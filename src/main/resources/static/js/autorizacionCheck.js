function togglePrecio(idCheckbox, idPrecio) {
    const checkbox = document.getElementById(idCheckbox);
    const precio = document.getElementById(idPrecio);
    precio.disabled = !checkbox.checked;
  }