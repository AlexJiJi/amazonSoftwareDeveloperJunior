
const PRODUCTS_API_URL = "http://localhost:8080/api/v1/products";

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

// 3. Función para enviar los datos actualizados (PUT)
function updateProduct(productId, updatedData) {
    ajaxRequest(PRODUCTS_API_URL + '/' + productId, 'PUT', updatedData)
        .done(function () {
            alert('Product updated successfully!');
            window.location.href = 'index.html'; // Redirige al inicio tras actualizar
        })
        .fail(function (xhr) {
            handleError(xhr, 'update');
        });
}

// 4. Función para cargar los datos actuales del producto y preparar el formulario (GET)
function loadProductForEditing(productId) {
    ajaxRequest(PRODUCTS_API_URL + '/' + productId, 'GET')
        .done(function (product) {
            // Rellenamos los campos del formulario con los datos actuales
            $('#title').val(product.title);
            $('#price').val(product.price);
            $('#description').val(product.description);
            $('#productCategory').val(product.category);
            $('#imageURL').val(product.image);
            $('#rating').val(product.rating.rate);
            $('#ratingCount').val(product.rating.count);

            // IMPORTANTE: Capturamos el evento usando tu ID exacto #editProductForm
            $('#editProductForm').off('submit').on('submit', function (event) {
                event.preventDefault(); // Evita que recargue la página

                // Armamos el objeto con los datos modificados
                var updatedProduct = {
                    title: $('#title').val(),
                    price: parseFloat($('#price').val()),
                    description: $('#description').val(),
                    category: $('#productCategory').val(),
                    image: $('#imageURL').val(),
                    rating: {
                        rate: parseFloat($('#rating').val()),
                        count: parseInt($('#ratingCount').val(), 10)
                    }
                };

                // Llamamos a la función PUT
                updateProduct(productId, updatedProduct);
            });
        })
        .fail(function (xhr) {
            handleError(xhr, 'fetch');
        });
}

// 5. Lo que se ejecuta apenas carga la página
$(document).ready(function() {
    // Obtenemos el ID de la URL (ej. edit.html?id=3)
    var urlParams = new URLSearchParams(window.location.search);
    var productId = urlParams.get("id");

    if (productId) {
        // Si existe el ID, cargamos los datos del producto
        loadProductForEditing(productId);
    } else {
        alert("No product ID provided!");
        window.location.href = 'index.html'; // Si llegaste aquí por error sin ID, te regresa
    }
});





/*const PRODUCTS_API_URL = "http://localhost:8080/api/v1/products"

// fetch id parameter's value from window url
const urlParams = new URLSearchParams(window.location.search)
const productId = urlParams.get("id")

window.onload = function () {
    fetchProductFromAPI(productId)

    document.getElementById("editProductForm").addEventListener("submit", function (event) {
        event.preventDefault()
        updateProduct(productId)
    })
}

async function fetchProductFromAPI(productId) {
    try {
        const apiResponse = await fetch(`${PRODUCTS_API_URL}/${productId}`)
        if (!apiResponse.ok) {
            alert(`Error fetching product with ${productId} from API`)
        }
        await apiResponse.json().then(product => {
            preFillFormData(product)
        })
    } catch (error) {
        alert("Error fetching product from API")
    }
}

// TODO 10: create a function preFillFormData() to fill product details in edit product form
function preFillFormData(product) {
    document.getElementById("title").value = product.title
    document.getElementById("price").value = product.price
    document.getElementById("description").value = product.description
    document.getElementById("productCategory").value = product.category
    document.getElementById("imageURL").value = product.image
    document.getElementById("rating").value = product.rating.rate
    document.getElementById("ratingCount").value = product.rating.count
}

async function updateProduct(productId) {
    // TODO 11: fetch the form values and store them in a product object named 'updatedProduct'
    const updatedProduct = {
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

    // TODO 12: make a PUT request to the backend API and send the updatedProduct in the body as JSON
    try {
        await fetch(`${PRODUCTS_API_URL}/${productId}`, {
            method: "PUT",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(updatedProduct)
        })
        alert(`Product with ${productId} updated successfully`)
        loadProductDetailsPage(productId)
    } catch (error) {
        alert("Error updating product in API")
    }
}

function loadProductDetailsPage() {
    window.location.href = `product.html?id=${productId}`
}
    */