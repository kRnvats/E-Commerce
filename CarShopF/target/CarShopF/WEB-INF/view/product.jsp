<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="sp" %>
    <%@taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Product Page

<sp:form action="addProduct" method="post" modelAttribute="product" enctype="Multipart/form-data">
<c:if test="${not empty product.productName}">
Id<sp:input path="productId" readonly="true" disabled="true"/>
</c:if>
Name<sp:input path="productName"/>
Cost<sp:input path="productCost"/>
<sp:input type="file" path="image"/>
<sp:button type="submit">submit</sp:button>
</sp:form>




</body>
</html>