<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring"
uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <link rel="stylesheet" href="./css (2).css" />
    <link
      rel="stylesheet"
      href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"
      integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p"
      crossorigin="anonymous"
    />
    <style>
    * {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}
.top {
  height: 40vh;
  width: 100%;
  background-color: #eeeeee;
  padding: 40px;
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  justify-content: center;
}
.top h1 {
  font-size: 70px;
  color: #333333;
  font-weight: medium;
  margin-bottom: 20px;
}
.top p {
  font-size: 20px;
  color: #333333;
}
.bottom {
  height: auto;
  display: grid;
  grid-template-columns: 1fr 1fr 1fr 1fr;
  grid-template-rows: auto;
  place-items: center;
}
.box {
  border: 1px solid #333333;
  padding: 30px;
  /* flex: 0.3; */
  width: 70%;
  height: 70%;
  margin: 100px;
  display: flex;
  justify-content: center;
  align-items: flex-start;
  flex-direction: column;
}
.pic {
  max-width: 60%;
  margin: 0 auto;
  margin-bottom: 2rem;
}
.box h2 {
  font-size: 30px;
  color: #333333;
  font-weight: normal;
  margin-bottom: 15px;
}
.box p {
  font-size: 19px;
  font-weight: normal;
  color: #333333;
  margin-bottom: 12px;
}
.btn {
  background-color: #428bca;
  color: white;
  font-size: 15px;
  border: none;
  display: flex;
  justify-content: center;
  align-items: center;
  padding: 13px 21px;
  border-radius: 12px;
  margin-bottom: 1rem;
  cursor: pointer;
}
.box i {
  color: white;
  margin-right: 10px;
}
@media (max-width: 900px) {
  .bottom {
    grid-template-columns: repeat(2, 1fr);
  }
}
@media (max-width: 600px) {
  .bottom {
    grid-template-columns: repeat(1, 1fr);
  }
}
@media (max-width: 1200px) {
  .bottom {
    grid-template-columns: repeat(3, 1fr);
  }
}
    
    </style>
  </head>
  <body>
    <div class="top">
      <h1>Products</h1>
      <p>All the available products in our store</p>
    </div>
    <c:forEach items="${products}" var="product">
    <div class="bottom">
      <div class="box">
        <img src="<c:url value="/img/${product.productId}.jpg"> </c:url>" alt="image" style = "width:50%"/>
        <h2>${product.name}</h2>
        <p>
          ${product.description}
        </p>
        <p class="price">${product.unitPrice} USD</p>
        <p>Available ${product.unitsInStock} units in stock</p>
        <a href=" <spring:url value="/webstore/product?id=${product.productId}" /> "><button class="btn"><i class="fas fa-info"></i> Details</button></a>
      </div>
      </c:forEach>

  </body>
</html>
