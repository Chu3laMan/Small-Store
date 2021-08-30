<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Product</title>
    <link rel="stylesheet" href="./style.css">
    <style>
    * {
  margin: 0%;
  padding: 0%;
  box-sizing: border-box;
}
body {
  overflow-x: hidden;
}
header {
  height: 30vh;
  background-color: #eeeeee;
  width: 100%;
}
header h1 {
  font-size: 68px;
  color: black;
  padding: 85px 62px;
}
.container {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 70vh;
  width: 100%;
}
.left,
.right {
  flex: 1;
}
.right {
  display: flex;
  flex-direction: column;
  justify-content: space-evenly;
  align-items: flex-start;
  height: 70%;
}
.name {
  font-size: 40px;
  font-weight: medium;
}
.desc {
  width: 90%;
  font-size: 18px;
  line-height: 25px;
}
.right strong {
  font-size: 20px !important;
}
.orange {
  background-color: #f0ad4e;
  color: white;
}
.code {
  padding: 5px 10px;
  font-weight: bold;
  margin-left: 5px;
  border-radius: 2px;
}
.text {
  font-size: 18px;
}
.price {
  font-size: 25px;
}
.btns {
  display: flex;
  justify-content: flex-start;
  align-items: center;
}
.btns a {
  text-decoration: none;
}
.back {
  color: black;
  display: flex;
  align-items: center;
  justify-content: center;
  background: white;
  border: 1px solid #e3e3e3;
  padding: 15px 25px;
  border-radius: 10px;
  font-size: 15px;
  transition: all 0.25s ease-in-out;
}
.btns a i {
  margin-right: 10px;
}
.buy {
  display: flex;
  align-items: center;
  justify-content: center;
  padding: 15px 25px;
  border-radius: 10px;
  font-size: 15px;
  margin-left: 10px;
  transition: all 0.25s ease-in-out;
}
.buy:hover {
  opacity: 0.7;
  color: black;
}
.back:hover {
  background: rgba(0, 0, 0, 0.8);
  color: white;
}
@media screen and (max-width: 1400px) {
  .container {
    flex-direction: column;
    height: auto;
  }
  .left img {
    max-width: 100%;
  }
  .right {
    align-items: center;
  }
  .desc {
    width: 100%;
    text-align: center;
  }
  .name,
  .desc,
  .text,
  .btns {
    padding: 10px 0px;
  }
}
    
    </style>
</head>
<body>
    <header>
        <h1>Products</h1>
    </header>
    <div class="container">
        <div class="left">
            <img src="<c:url value="/img/${product.productId}.jpg"> </c:url>" alt="image" style = "width:80%"/>
        </div>
        <div class="right"> 
            <h3 class="name">${product.name}</h3>
            <p class="desc">${product.description}</p>
            <p class="text"><strong>Item Code:</strong>  <span class="orange code">${product.productId}</span></p>
            <p class="text"><strong>Manufacturer:</strong>${product.manufacturer}</p>
            <p class="text"><strong>Category:</strong>${product.category}</p>
            <p class="text"><strong>Available units in stock:</strong>${product.unitsInStock}</p>
            <p class="price">${product.unitPrice} USD</p>
            <div class="btns">
                <a href="<spring:url value="/webstore/products" /> " class="back"><i class="far fa-hand-point-left"></i> Back</a>
                <a href="<spring:url value="/webstore/products" /> " class="orange buy"><i class="fas fa-shopping-cart"></i> Order Now</a>
            </div>
        </div> 
    </div>
</body>
</html>