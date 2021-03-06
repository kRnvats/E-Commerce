
<%@include file="header.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sp" %>  

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/productdetail.css">

    <title>eCommerce Product Detail</title>
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,700" rel="stylesheet">

  </head>

  <body style="background-image=";>
	
	<div class="container" >
		<div class="card"style="background:white" >
			<div class="container-fliud">
							<img src="${pageContext.request.contextPath }/resources/images/${c.productId}.jpg" style="width:400px;height:400px;"/>


					<div class="details col-md-6">
						<h3 class="product-title">${c.productName }</h3>
						<div class="rating">
							<div class="stars">
								<span class="fa fa-star checked"></span>
								<span class="fa fa-star checked"></span>
								<span class="fa fa-star checked"></span>
								<span class="fa fa-star"></span>
								<span class="fa fa-star"></span>
							</div>
							<span class="review-no">41 reviews</span>
						</div>
						<p class="product-description">${c.productDesc }</p>
						<h4 class="price">Our price: <span>&#8377; ${c.productCost }</span></h4>
						<p class="vote"><strong>91%</strong> of buyers enjoyed this product! <strong>(87 votes)</strong></p>
						
						
						<div class="action">
							<a class="add-to-cart btn btn-default" href="${pageContext.request.contextPath}/myCart/addToCart/${c.productId}">add to cart</a>
						</div>
					</div>
				</div>
			</div>
		</div>
<div class="container" >
		<div class="row" >
		<h3 class="text-center">Users Also Bought</h3>
		
         <c:forEach items="${pro}" var="c" begin="${ c}+4" end="${ c}+6">
         
        
        <div class="col-md-4" style="color:black">
             
         
      
          <div class="card card-01 w3-animate-left" >
          
          <img class="card-img-top" src="${pageContext.request.contextPath }/resources/images/${c.productId}.jpg"  alt="${c.productName}" align="middle" style="display: block;margin: 0 auto;width:max-width;height:150px">
          <div class="card-block">
            <span class="badge-box"><a href="${pageContext.request.contextPath }/myCart/addToCart/${c.productId}"><i class="fa fa-shopping-cart"></i></a></span>
            <h4 align="center" class="card-title" > ${c.productName }</h4>
            <h4  align="center" class="card-text"> &#8377; ${c.productCost }</h4>
            <a href="${pageContext.request.contextPath }/ProductDetail/${c.productId}" class="btn btn-default text-uppercase">More Details</a>
          
          
          </div>
            
        </div>
  
        </div>
         </c:forEach>
         
        </div>
        </div>
  </body>
</html>


