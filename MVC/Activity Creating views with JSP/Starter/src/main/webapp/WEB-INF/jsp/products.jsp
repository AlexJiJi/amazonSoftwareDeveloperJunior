<!DOCTYPE html>
<html>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
    <head>
        <Title>Product List </Title>
        <link rel="stylesheet" href="/css/product-styles.css">
    </head>
    <body>
        <h1> Available Products </h1>
        <table border = "1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Price</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="product" items="${products}">
                    <tr>
                        <td>${product.id}</td>
                        <td>${product.name}</td>
                        <td>${product.description}</td>
                        <td>$${product.price}</td>
                    </tr>
                </c:forEach>
            </tbody>
         </table>
    </body>
</html>