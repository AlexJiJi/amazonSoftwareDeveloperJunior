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

// 3. Obtener el producto de la API usando GET
function fetchProductFromAPI(productId) {
    ajaxRequest(PRODUCTS_API_URL + '/' + productId, 'GET')
        .done(function (product) {
            displayProduct(product); // Si tiene éxito, dibujamos el producto
        })
        .fail(function (xhr) {
            handleError(xhr, 'fetch');
        });
}

// 4. Mostrar el producto en el contenedor
function displayProduct(product) {
    var productContainer = $("#productDetailsContainer");
    productContainer.empty(); // Limpia el contenedor por si acaso

    // Usamos la misma estructura de clases que tenías para mantener tus estilos CSS
    var productHtml = `
        <div class="product-detail-card">
            <img src="${product.image}" alt="${product.title}">
            <h2>${product.title}</h2>
            <p><strong>Price:</strong> $ ${product.price.toFixed(2)}</p>
            <p><strong>Description:</strong> ${product.description}</p>
            <p><strong>Category:</strong> ${product.category}</p>
            <p><strong>Rating:</strong> ${product.rating.rate} (Count: ${product.rating.count})</p>
            <section class="product-card-buttons-container">
                <button class="product-card-button edit-product-button" onclick="editProductById(${product.id})" type="button">
                    ✏️ Edit
                </button>
                <button class="product-card-button delete-product-button" onclick="deleteProductById(${product.id})" type="button">
                    🗑️ Delete
                </button>
            </section>
        </div>
    `;
    
    productContainer.html(productHtml);
}

// 5. Función para redirigir a la página de edición
function editProductById(productId) {
    window.location.href = 'edit.html?id=' + productId;
}

// 6. Función para eliminar el producto usando DELETE (tal como viene en tu lectura)
function deleteProductById(productId) {
    if (confirm('Are you sure you want to delete this product?')) {
        ajaxRequest(PRODUCTS_API_URL + '/' + productId, 'DELETE')
            .done(function() {
                alert('Product deleted successfully!');
                window.location.href = 'index.html'; // Redirige al inicio tras borrarlo
            })
            .fail(function(xhr) {
                handleError(xhr, 'delete');
            });
    }
}

// 7. Lo que se ejecuta apenas carga la página
$(document).ready(function() {
    // Leer el ID que viene en la barra de direcciones (URL)
    var urlParams = new URLSearchParams(window.location.search);
    var productId = urlParams.get("id");
    
    // Si hay un ID, mandamos a pedir ese producto
    if(productId) {
        fetchProductFromAPI(productId);
    } else {
        $("#productDetailsContainer").html("<p>Product ID not found.</p>");
    }
});

/*const PRODUCTS_API_URL = "http://localhost:8080/api/v1/products"

window.onload = function () {
    // fetch id parameter's value from window url
    const urlParams = new URLSearchParams(window.location.search)
    const productId = urlParams.get("id")

    fetchProductFromAPI(productId)
}

// TODO 4: create an async function fetchProductFromAPI() that fetches a single product by ID from the backend API
async function fetchProductFromAPI(productId) {
    try {
        const apiResponse = await fetch(`${PRODUCTS_API_URL}/${productId}`)
        if (!apiResponse.ok) {
            alert(`Error fetching product with ${productId} from API`)
        }
        await apiResponse.json().then(
            product => {
                displayProduct(product)
            }
        )
    } catch (error) {
        alert("Error fetching product from API")
    }
}

// TODO 5: create a function displayProduct() that displays the product details with edit and delete buttons
function displayProduct(product) {
    const productContainer = document.getElementById("productDetailsContainer")
    productContainer.innerHTML = ""

    const productElement = document.createElement("div")
    productElement.classList.add("product-card")
    productElement.innerHTML = `
        <div class="product-detail-card">
            <img src="${product.image}" alt="${product.title}">
            <h2>${product.title}</h2>
            <p><strong>Price:</strong> $ ${product.price.toFixed(2)}</p>
            <p><strong>Description:</strong> ${product.description}</p>
            <p><strong>Category:</strong> ${product.category}</p>
            <p><strong>Rating:</strong> ${product.rating.rate} (Count: ${product.rating.count})</p>
            <section class="product-card-buttons-container">
                <button class="product-card-button edit-product-button" onclick="editProductById(${product.id})" type="button">
                    ✏️
                </button>
                <button class="product-card-button delete-product-button" onclick="deleteProductById(${product.id})" type="button">
                    🗑️
                </button>
            </section>
        </div>
    `
    productContainer.appendChild(productElement)
}

// TODO 9: create a function editProduct() to open the edit.html page with a product id as URL parameter 'id'
function editProductById(productId) {
    window.location.href = `edit.html?id=${productId}`
}

// TODO 13: create an async function deleteProductById() that makes a DELETE request to the backend with product ID
async function deleteProductById(productId) {
    const deletionConfirmation = confirm(`Are you sure you want to delete product with ${productId}?`)

    if (!deletionConfirmation) {
        return
    }

    try {
        const apiResponse = await fetch(`${PRODUCTS_API_URL}/${productId}`, {
            method: "DELETE"
        })
        if (!apiResponse.ok) {
            alert(`Error deleting product with ${productId} from API`)
        }
        alert(`Product with ${productId} deleted successfully`)
        window.location.href = "index.html"
    } catch (error) {
        alert("Error deleting product from API")
    }
}
*/