<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form"
uri="http://www.springframework.org/tags/form"
%>
<%@ taglib prefix="spring"
uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Add a new product</title>
    <link rel="stylesheet" href="http://localhost:8002/sampleStore/resources/style.css" />
  </head>
  <body>
    <h3>Add new product</h3>
    <hr />
    <div class="inputs">
    <form:form method="POST" modelAttribute="newProduct"> 
      <div class="input">
        <label for="id"><spring:message code="addProduct.form.productId.label"/></label>
        <form:input path="productId" type="text" id="productId" />
        <form:errors path="productId" class="text-danger" />
      </div>
      
      <div class="input">
        <label for="name">Name</label>
        <form:input path="name" type="text" id="name" />
        <form:errors path="name" class="text-danger" />
      </div>
      
      <div class="input">
        <label for="price">Unit Price</label>
        <form:input path="unitPrice" type="text" id="unitPrice" />
        <form:errors path="unitPrice" class="text-danger" />
      </div>
      
      <div class="input">
        <label for="Manufacturer">Manufacturer</label>
        <form:input path="manufacturer" type="text" id="manufacturer" />
        <form:errors path="manufacturer" class="text-danger" />
      </div>
      
      <div class="input">
        <label for="Category">Category</label>
        <form:input path="category" type="text" id="category" />
        <form:errors path="category" class="text-danger" />
      </div>
      
      <div class="input">
        <label for="stock">Units in stock</label>
        <form:input path="unitsInStock" type="text" id="unitsInStock" />
        <form:errors path="unitsInStock" class="text-danger" />
      </div>
      
      <div class="input">
      <label>Unit in Order:</label>
      <form:input path="unitsInOrder" type="text" id="unitsInOrder" />
      <form:errors path="unitsInOrder" class="text-danger" />
      </div>
      
      <div class="input">
        <label for="desc">Description</label>
        <form:textarea path="description" type="text" id="description" row="2" />
        <form:errors path="description" class="text-danger" />
      </div>
      
      <div class="input">
        <label for="Condition">Condition</label>
        <div class="radio-div">
          <div class="radio">
            <label for="new">New</label>
            <input type="radio" name="rad" id="new" />
          </div>
          <div class="radio">
            <label for="old">Old</label>
            <input type="radio" name="rad" id="old" />
          </div>
          <div class="radio">
            <label for="Refurbished">Refurbished</label>
            <input type="radio" name="rad" id="Refurbished" />
          </div>
        </div>
      </div>
      
      <div class="input">
        <label for="Image">Product Image File</label>
        <input type="file" alt="" id="img" />
      </div>
      <button>Add</button>
      </form:form>
    </div>
  </body>
</html>