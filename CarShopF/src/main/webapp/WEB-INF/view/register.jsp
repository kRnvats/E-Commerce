<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sp" %>
<%@include file="header.jsp" %>
<%@ page isELIgnored="false" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title> Register to CarShopF</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="http://netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
    <style type="text/css">
        
    </style>
    <script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
    <script src="http://netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
	
</head>
<body>
<sp:form action="${pageContext.request.contextPath }/addUser" method="POST" modelAttribute="user">
<div class="container-fluid">
    <section class="container">
		<div class="container-page">				
			<div class="col-md-6">
				<h3 class="dark-grey">Registration</h3>
				
				<div class="form-group col-lg-12">
					<label>Username</label>
					<input type="text" name="username" class="form-control" id="" value="">
				</div>
				
				<div class="form-group col-lg-6">
					<label>Password</label>
					<input type="text" name="password" class="form-control" id="" value="">
				</div>
				
								
				<div class="form-group col-lg-6">
					<label>Email Address</label>
					<input type="text" name="email" class="form-control" id="" value="">
				</div>
				
<br>
<br>
	<h2> BillingAddress</h2>			
				<div class="form-group col-lg-12">
					<label>StreetName</label>
					<input type="text" name="billingDetails.StreetName" class="form-control" id="" value="">
				</div>	
				
				<div class="form-group col-lg-12">
					<label>ApartNo</label>
					<input type="text" name="billingDetails.ApartNo" class="form-control" id="" value="">
				</div>
				
				<div class="form-group col-lg-12">
					<label>City</label>
					<input type="text" name="billingDetails.City" class="form-control" id="" value="">
				</div>
				
				<div class="form-group col-lg-12">
					<label>State</label>
					<input type="text" name="billingDetails.State" class="form-control" id="" value="">
				</div>
				
				<div class="form-group col-lg-12">
					<label>Country</label>
					<input type="text" name="billingDetails.Country" class="form-control" id="" value="">
				</div>
				
				<div class="form-group col-lg-12">
					<label>Zipcode</label>
					<input type="text" name="billingDetails.Zipcode" class="form-control" id="" value="">
				</div>
				<br>
				
			<h2>ShippingAddress</h2>
			<div class="form-group col-lg-12">
					<label>StreetName</label>
					<input type="text" name="shippingDetails.StreetName" class="form-control" id="" value="">
				</div>	
				
				<div class="form-group col-lg-12">
					<label>ApartNo</label>
					<input type="text" name="shippingDetails.ApartNo" class="form-control" id="" value="">
				</div>
				
				<div class="form-group col-lg-12">
					<label>City</label>
					<input type="text" name="shippingDetails.City" class="form-control" id="" value="">
				</div>
				
				<div class="form-group col-lg-12">
					<label>State</label>
					<input type="text" name="shippingDetails.State" class="form-control" id="" value="">
				</div>
				
				<div class="form-group col-lg-12">
					<label>Country</label>
					<input type="text" name="shippingDetails.Country" class="form-control" id="" value="">
				</div>
				
				<div class="form-group col-lg-12">
					<label>Zipcode</label>
					<input type="text" name="shippingDetails.Zipcode" class="form-control" id="" value="">
				</div>
				<div class="col-sm-6">
				<input type="checkbox" class="checkbox" />Sigh up for our newsletter
				</div>

				<div class="col-sm-6">
					<input type="checkbox" class="checkbox" />Send notifications to this email
				</div>				
			
			</div>
		
		
		
			<div class="col-md-6">
				<h3 class="dark-grey">Terms and Conditions</h3>
				<p>
					By clicking on "Register" you agree to The Company's' Terms and Conditions
				</p>
				<p>
					While rare, prices are subject to change based on exchange rate fluctuations - 
					should such a fluctuation happen, we may request an additional payment. You have the option to request a full refund or to pay the new price. (Paragraph 13.5.8)
				</p>
				<p>
					Should there be an error in the description or pricing of a product, we will provide you with a full refund (Paragraph 13.5.6)
				</p>
				<p>
					Acceptance of an order by us is dependent on our suppliers ability to provide the product. (Paragraph 13.5.6)
				</p>
				
				<button type="submit" class="btn btn-primary">Register</button>
			</div>
		</div>
	</section>
</div>
<script type="text/javascript">

</script>
</sp:form>
</body>
</html>
