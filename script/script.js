const showcase = document.getElementById('showcase');
const paginationContainer = document.getElementById('pagination');

let currentPage = 1;
const itemsPerPage = 6;
let librosData = [];

// Cargar datos desde el archivo JSON

fetch('script/libros.json')
    .then(response => response.json())
    .then(libros => {
        librosData = libros;
        renderPage(currentPage);
    })
    .catch(error => console.error('Error al cargar los datos:', error));


// Función para renderizar la página actual

function renderPage(page) {
    showcase.innerHTML = '';              // Limpiar el contenedor
    const start = (page - 1) * itemsPerPage; // Índice inicial
    const end = start + itemsPerPage;     // Índice final
    const pageItems = librosData.slice(start, end);
    pageItems.forEach(libro => {
        const tarjeta = document.createElement('div');
        tarjeta.className = 'tarjeta';
        const precioConDescuento = ((100 - libro.descuento) / 100) * libro.precioCompra;
        tarjeta.innerHTML = `
                ${libro.oferta ? `<img src="img/oferta.png" class="icono-oferta" alt="Oferta">
                                    <h2 class="descuento">-${libro.descuento}%</h2></div>` : ``
            }
                ${libro.bestseller ? `<img src="img/bestseller.png" class="icono-bestseller" alt="Bestseller">` : ``
            }
                <div class="info-libro">
                <div class="imagen-tarjeta">
                    <img src="${libro.urlImagen}" alt="${libro.titulo}">
                </div>
                <div class="info-tarjeta">
                    <h2 class="titulo">${libro.titulo}</h2>
                    <p class="autor">${libro.autor}</p>
                    ${libro.oferta ? `<h2 class="oferta">$${precioConDescuento.toFixed(2)}</h2>
                                        <h2 class="compra-oferta">$${libro.precioCompra.toFixed(2)}</h2>` :
                `<h2 class="precio compra">$${libro.precioCompra.toFixed(2)}</h2>`
            }
                    
                </div>
                </div>
                
            `;
        tarjeta.addEventListener('click', () => selectItem(tarjeta));
        showcase.appendChild(tarjeta);
    });
    renderPagination(librosData, renderPage);

}

// Función para seleccionar un ítem

function selectItem(tarjeta) {
    // Lógica para seleccionar una tarjeta
    showcase.innerHTML = ''; // Limpiar el contenedor
    const item = librosData.find(libro => libro.titulo === tarjeta.querySelector('.titulo').textContent);
    const infoItem = document.createElement('div');
    const precioConDescuento = ((100 - item.descuento) / 100) * item.precioCompra;
    infoItem.className = 'item';
    let description = "lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.";
    infoItem.innerHTML = `
            <div class="imagen-item">
                <img src="${item.urlImagen}" alt="${item.titulo}">
            </div>
            <div class="info-item">
                <h2 class="titulo-item">${item.titulo}</h2>
                <p class="autor-item">${item.autor}</p>
                <p class="descripcion-item">${description}</p>
                ${item.oferta ? `<h2 class="item-oferta">$${precioConDescuento.toFixed(2)}</h2>
                                        <h2 class="item-compra-oferta">$${item.precioCompra.toFixed(2)}</h2>` :
            `<h2 class="item-compra-base">$${item.precioCompra.toFixed(2)}</h2>`
        }
            </div>
        `;
    showcase.appendChild(infoItem);
}

// Función para renderizar Ofertas

function renderOfertas(pageOfertas) {
    showcase.innerHTML = ''; // Limpiar el contenedor
    const librosConOferta = librosData.filter(libro => libro.oferta);
    const start = (pageOfertas - 1) * itemsPerPage; // Índice inicial
    const end = start + itemsPerPage;     // Índice final
    const pageItems = librosConOferta.slice(start, end);

    pageItems.forEach(libro => {
        const tarjeta = document.createElement('div');
        tarjeta.className = 'tarjeta';
        const precioConDescuento = ((100 - libro.descuento) / 100) * libro.precioCompra;
        tarjeta.innerHTML = `
            
                <img src="img/oferta.png" class="icono-oferta" alt="Oferta">
                <h2 class="descuento">-${libro.descuento}%</h2></div>

                ${libro.bestseller ? `<img src="img/bestseller.png" class="icono-bestseller" alt="Bestseller">` : ``
            }
                <div class="info-libro">
                <div class="imagen-tarjeta">
                    <img src="${libro.urlImagen}" alt="${libro.titulo}">
                </div>
                <div class="info-tarjeta">
                    <h2 class="titulo">${libro.titulo}</h2>
                    <p class="autor">${libro.autor}</p>
                    ${libro.oferta ? `<h2 class="oferta">$${precioConDescuento.toFixed(2)}</h2>
                                        <h2 class="compra-oferta">$${libro.precioCompra.toFixed(2)}</h2>` :
                `<h2 class="precio compra">$${libro.precioCompra.toFixed(2)}</h2>`
            }
                    
                </div>
            `;
        tarjeta.addEventListener('click', () => selectItem(tarjeta));
        showcase.appendChild(tarjeta);
    });
    renderPagination(librosConOferta, renderOfertas);

}
const menuOferta = document.getElementById('menu-oferta');
menuOferta.addEventListener('click', () => { renderOfertas(1); });

// Función para renderizar Bestsellers

function renderBestsellers(pageBestsellers) {
    showcase.innerHTML = ''; // Limpiar el contenedor
    const librosConBestseller = librosData.filter(libro => libro.bestseller);
    const start = (pageBestsellers - 1) * itemsPerPage; // Índice inicial
    const end = start + itemsPerPage;     // Índice final
    const pageItems = librosConBestseller.slice(start, end);

    pageItems.forEach(libro => {
        const tarjeta = document.createElement('div');
        tarjeta.className = 'tarjeta';
        const precioConDescuento = ((100 - libro.descuento) / 100) * libro.precioCompra;
        tarjeta.innerHTML = `
                ${libro.bestseller ? `<img src="img/bestseller.png" class="icono-bestseller" alt="Bestseller">` : ``
            }
                <div class="info-libro">
                <div class="imagen-tarjeta">
                    <img src="${libro.urlImagen}" alt="${libro.titulo}">
                </div>
                <div class="info-tarjeta">
                    <h2 class="titulo">${libro.titulo}</h2>
                    <p class="autor">${libro.autor}</p>
                    ${libro.oferta ? `<h2 class="oferta">$${precioConDescuento.toFixed(2)}</h2>
                                        <h2 class="compra-oferta">$${libro.precioCompra.toFixed(2)}</h2>` :
                `<h2 class="precio compra">$${libro.precioCompra.toFixed(2)}</h2>`
            }
                    
                </div>
            `;
        tarjeta.addEventListener('click', () => selectItem(tarjeta));
        showcase.appendChild(tarjeta);
    });
    renderPagination(librosConBestseller, renderBestsellers);

}
const menuBestseller = document.getElementById('menu-best-sellers');
menuBestseller.addEventListener('click', () => { renderBestsellers(1); });

function renderConocenos() {
    showcase.innerHTML = '';

}

// Función para renderizar los botones de páginas

function renderPagination(listaLibros, renderFn) {
    paginationContainer.innerHTML = "";
    const totalPages = Math.ceil(listaLibros.length / itemsPerPage);

    for (let i = 1; i <= totalPages; i++) {
        const btn = document.createElement('button');
        btn.textContent = i;
        if (i === currentPage) btn.classList.add('active');
        btn.addEventListener('click', () => {
            currentPage = i;
            renderFn(currentPage);
        });
        paginationContainer.appendChild(btn);
    }
}

