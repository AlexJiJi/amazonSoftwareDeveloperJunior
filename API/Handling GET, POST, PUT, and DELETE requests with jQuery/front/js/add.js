// 1. Función principal para manejar las peticiones AJAX
function ajaxRequest(url, method, data) {
    return $.ajax({
        url: url,
        method: method,
        contentType: 'application/json',
        data: data ? JSON.stringify(data) : undefined
    });
}

// 2. Función para manejar errores
function handleError(xhr, action) {
    var errorMsg = {
        404: 'Resource not found',
        403: 'Unauthorized request',
        500: 'Server error',
        0: 'Network error - request was blocked'
    };
    var status = xhr.status;
    var message = errorMsg[status] || 'Unexpected error: ' + status;
    alert('Failed to ' + action + ' product. ' + message);
}

// 3. Función POST para agregar el producto a la base de datos
function addProduct(productData) {
    ajaxRequest('http://localhost:8080/api/v1/products', 'POST', productData)
        .done(function() {
            alert('Product added successfully!');
            window.location.href = 'index.html'; // Te regresa al inicio si todo salió bien
        })
        .fail(function(xhr) {
            handleError(xhr, 'add');
        });
}

// 4. Capturar el evento del formulario (Se ejecuta cuando la página carga)
$(document).ready(function() {
    $('#addProductForm').on('submit', function(event) {
        event.preventDefault(); // Evita que la página se recargue por defecto

        // Armamos el objeto con los valores que el usuario escribió en el HTML
        var newProduct = {
            title: $('#title').val(),
            price: parseFloat($('#price').val()),
            description: $('#description').val(),
            category: $('#productCategory').val(),
            image: $('#imageURL').val(),
            rating: {
                rate: parseFloat($('#rating').val()) || 0,
                count: parseInt($('#ratingCount').val(), 10) || 0
            }
        };
        
        // Llamamos a la función POST pasándole los datos
        addProduct(newProduct);
    });
});


/*const PRODUCTS_API_URL = "http://localhost:8080/api/v1/products"

async function addProduct() {
    // TODO 6: fetch the form values from the #addProductForm in add.html and create a product object
    const product = {
        title: document.getElementById("title").value,
        price: parseFloat(document.getElementById("price").value),
        description: document.getElementById("description").value,
        category: document.getElementById("productCategory").value,
        image: document.getElementById("imageURL").value,
        rating: {
            rate: parseFloat(document.getElementById("rating").value),
            count: parseInt(document.getElementById("ratingCount").value)
        }
    }

    // TODO 7: make a POST request to the backend API and send the product in the body as JSON
    try {
        await fetch(
            PRODUCTS_API_URL,
            {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(product)
            }
        )
        alert("Product added successfully")
        window.location.href = "index.html"
    } catch (error) {
        alert("Error adding product to API")
    }
}

// TODO 8: add an evenlistener on the submit button of the #addProductForm in add.html
window.onload = function () {
    document.getElementById("addProductForm").addEventListener("submit", function (event) {
        event.preventDefault()
        addProduct()
    })
}
    */

