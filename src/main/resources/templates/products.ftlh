<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <#--    <title>${name}!</title>-->
    <title>DevCatalog</title>
</head>
<body>
<#--<h2>Hello ${name}!</h2>-->
<h1>Products</h1>
<#list productList as product>
    <div>
        <p><b>${product.title}</b> ${product.price} USD | <a href="/product/${product.id}">Details...</a></p>
    </div>
</#list>
<h3>New product</h3>
<form action="/product/create" method="post">
    Product name: <input type="text" name="title"/><br><br>
    Product description: <input type="text" name="description"/><br><br>
    Product price: <input type="number" name="price"/><br><br>
    Product city: <input type="text" name="city"/><br><br>
    Product author: <input type="text" name="author"/><br><br>
    <input type="submit" value="Add item"/>
</form>
</body>
</html>