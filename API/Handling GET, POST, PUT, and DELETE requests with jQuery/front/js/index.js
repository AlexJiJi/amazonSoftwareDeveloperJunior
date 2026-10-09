// Main function to handle all AJAX requests
function ajaxRequest(url, method, data) {
    return $.ajax({
        url: url,
        method: method,
        contentType: 'application/json',
        data: data ? JSON.stringify(data) : undefined
    });
}

function fetchProducts() {
    ajaxRequest('http://localhost:8080/api/v1/products', 'GET')
        .done(function(products) {
            var productContainer = $('#productContainer');
            productContainer.empty();
            var productCards = $.map(products, function(product) {
                return `
                    <div class="product-card">
                        <img src="${product.image}" alt="${product.title}">
                        <a href="product.html?id=${product.id}">${product.title}</a>
                        <p>$${product.price.toFixed(2)} Rating: ${product.rating.rate}</p>
                    </div>
                `;
            }).join('');
            productContainer.html(productCards);
        })
        .fail(function(xhr) {
            handleError(xhr, 'fetch');
        });
}

//Funcion general para manejar errores de peticiones AJAX
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

// Ejecutar cuando el documento esté listo (buena práctica en jQuery)
$(document).ready(function() {
    fetchProducts();
});




/*
CODIGO PARA HACER LO MISMO CON FETCH
// const PRODUCTS_API_URL = "http://localhost:8080/api/v1/products"
const PRODUCTS_API_URL = "http://127.0.0.1:8080/api/v1/products"
let products = []

// TODO 1: create an async function fetchProductsFromAPI() that makes a GET request to the backend API and fetches all products as JSON
async function fetchProductsFromAPI() {
    try {
        const apiResponse = await fetch(PRODUCTS_API_URL)
        if (!apiResponse.ok) {
            alert("Error fetching products from API")
            console.log(apiResponse.statusText);
            console.log(error);
        }
        products = await apiResponse.json()
    } catch (error) {
        alert("Error fetching products from API")
        console.log(error);
    }
}

// TODO 2: create a function displayProducts() that renders the products in a product card inside the productContainer in index.html
function displayProducts() {
    const productsContainer = document.getElementById("productContainer")
    productsContainer.innerHTML = ""

    products.forEach(product => {
        const productElement = document.createElement("div")
        productElement.classList.add("product-card")
        productElement.innerHTML = `
            
            <a href="product.html?id=${product.id}">
                <img src="${product.image}" alt="${product.title}">
                ${product.title}
            </a>
            <p>$${product.price.toFixed(2)} Rating: ${product.rating.rate}</p>
        `
        productsContainer.appendChild(productElement)
    })
}

// TODO 3: call the fetchProductsFromAPI() function and the displayProducts() function on window load
window.onload = async function () {
    await fetchProductsFromAPI()
    displayProducts()
}
    */