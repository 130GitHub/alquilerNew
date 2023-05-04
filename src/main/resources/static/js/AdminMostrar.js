function mostrar() {
  let opcion = document.getElementById("admin2").value;
      
  if (opcion == "posteo") {
    document.getElementById("contenido1").style.visibility= 'visible';
    document.getElementById("contenido2").style.visibility= 'hidden';
    document.getElementById("contenido3").style.visibility= 'hidden';

  } else if (opcion == "publico") {
    document.getElementById("contenido1").style.visibility= 'hidden';
    document.getElementById("contenido2").style.visibility= 'visible';
    document.getElementById("contenido3").style.visibility= 'hidden';

  } else if (opcion == "usuario") {
    document.getElementById("contenido1").style.visibility= 'hidden';
    document.getElementById("contenido2").style.visibility= 'hidden';
    document.getElementById("contenido3").style.visibility= 'visible';
    
  }
}