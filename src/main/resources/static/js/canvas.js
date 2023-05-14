//PARA CAMBIAR FOTO PERFIL
        // Obtener referencias a los elementos del DOM
      const imageUploadInput = document.getElementById('image-upload');
      const canvas = document.getElementById('image-canvas');
      const applyFilterButton = document.getElementById('apply-filter');

      // Manejar el evento de cambio de la carga de la imagen
      imageUploadInput.addEventListener('change', function(e) {
        const file = e.target.files[0];
        
        // Crear un objeto FileReader para leer el contenido del archivo
        const reader = new FileReader();
        
        reader.onload = function(event) {
          // Crear un elemento de imagen y establecer la fuente en el contenido leído
          const image = new Image();
          image.src = event.target.result;
          
          // Cuando la imagen se cargue, dibujarla en el lienzo
          image.onload = function() {
            const context = canvas.getContext('2d');
            canvas.width = image.width;
            canvas.height = image.height;
            context.drawImage(image, 0, 0);
          };
        };
        
        // Leer el contenido del archivo como una URL de datos
        reader.readAsDataURL(file);
      });

      // Manejar el evento de clic en el botón de aplicar filtro
      applyFilterButton.addEventListener('click', function() {
        const context = canvas.getContext('2d');
        const imageData = context.getImageData(0, 0, canvas.width, canvas.height);
        
        // Aplicar algún filtro o edición a los datos de la imagen
        // Aquí puedes agregar tu lógica de edición de imagen
        
        // Volver a dibujar la imagen editada en el lienzo
        context.putImageData(imageData, 0, 0);
      });
