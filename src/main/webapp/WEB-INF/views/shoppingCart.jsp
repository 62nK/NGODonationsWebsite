<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Log in</title>
<link rel="stylesheet" href="styles/shopping_cart.css" />
</head>
<body>


<h1>Shopping Cart</h1>

<div class="shopping-cart">

  <div class="column-labels">
    <label class="product-details">Product</label>
    <label class="product-quantity">Quantity</label>
    <label class="product-price">Price</label>
    <label class="product-line-price">Total</label>
  </div>

  <div class="product">
  
    <div class="product-details">
      <div class="product-title">Product 1</div>
      <p class="product-description"></p>
    </div>
    <div class="product-price">12.99</div>
    <div class="product-quantity">
      <input type="number" value="2" min="1">
    </div>
    <div class="product-removal">
      <button class="remove-product">
        Remove
      </button>
    </div>
    <div class="product-line-price">25.98</div>
  </div>

  <div class="product">
   
    <div class="product-details">
      <div class="product-title">Product 2</div>

    </div>
    <div class="product-price">45.99</div>
    <div class="product-quantity">
      <input type="number" value="1" min="1">
    </div>
    <div class="product-removal">
      <button class="remove-product">
        Remove
      </button>
      
    </div>
    <div class="product-line-price">45.99</div>
  </div>

  <div class="totals">
    <div class="totals-item">
      <label>Subtotal</label>
      <div class="totals-value" id="cart-subtotal">71.97</div>
    </div>
   
  </div>
      
      <button class="checkout">Checkout</button>
 <div class="btn-group">
  <button style="margin:5px;">Empty Cart</button>
  <button style="margin:5px;">Update Cart</button>
</div> 
</body>
</html>