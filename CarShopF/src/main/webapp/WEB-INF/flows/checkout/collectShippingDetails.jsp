<%@include file="/WEB-INF/view/header.jsp"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="space"></div>
<div class="container">
	<h2 class="heading-one">Customer Details</h2>

	<form:form modelAttribute="order">

		<h3>Shipping Address</h3>

		<div class="form-group">
			<label for="shippingStreet">StreetName</label>
			<form:input path="userr.shippingDetails.StreetName"
				id="shippingStreet" class="form-control" />
		</div>

		<div class="form-group">
			<label for="shippingApartmentNumber">ApartNo</label>
			<form:input path="userr.shippingDetails.ApartNo"
				id="shippingApartmentNumber" class="form-control" />
		</div>

		<div class="form-group">
			<label for="shippingZip">City</label>
			<form:input path="userr.shippingDetails.City"
				id="shippingZip" class="form-control" />
		</div>
		<div class="form-group">
			<label for="shippingStreet">State</label>
			<form:input path="userr.shippingDetails.State"
				id="shippingStreet" class="form-control" />
		</div>

		<div class="form-group">
			<label for="shippingApartmentNumber">Country</label>
			<form:input path="userr.shippingDetails.Country"
				id="shippingApartmentNumber" class="form-control" />
		</div>

		<div class="form-group">
			<label for="shippingZip">Zipcode</label>
			<form:input path="userr.shippingDetails.Zipcode"
				id="shippingZip" class="form-control" />
		</div>

		<input type="hidden" name="_flowExecutionKey" />

		<br>
		<br>
		<button class="btn btn-danger"
			name="_eventId_backToCollectCustomerInfo">Back</button>
		<input type="submit" value="Next" class="btn btn-success"
			name="_eventId_shippingDetailCollected" />
		<button class="btn btn-warning" name="_eventId_cancel">Cancel</button>
	</form:form>


</div>

