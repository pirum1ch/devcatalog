<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>DevCatalog</title>
</head>
<body>
<h1>Products Details</h1>
<hr>
<b>Product name: </b>${product.title}<br>
<b>Product Description: </b>${product.description}<br>
<b>Product price: </b>${product.price}<br>
<b>Product city: </b>${product.city}<br>
<b>Product author: </b>${product.author}<br>
<hr>
<form action="/product/delete/${product.id}" method="post">
    Product name: <input type="submit" value="Detele"/>
</form>
</body>
</html>