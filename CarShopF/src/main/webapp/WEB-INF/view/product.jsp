<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false" %>
    
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="sp" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
Product Id<sp:input path="productId" readonly="true" disabled="true"/>
<sp:hidden path="productId"/>
</c:if>
Product Name<sp:input path="productName"/>
Product Cost<sp:input path="productCost"/>
<sp:input type="file" path="image"/>
<sp:select path="categoryId">
<c:forEach items="${categoryList}" var="c">
		<sp:option value="${c.categoryID}">${c.categoryName}</sp:option>
</c:forEach>
</sp:select>
<c:if test="${empty product.productName }">
<sp:button value="submit">ADD</sp:button>
</c:if>
<c:if test="${not empty product.productName }">
<sp:button type="submit">submit</sp:button>
</c:if>
</sp:form>


<c:if test="${not empty productList }">
<table width="50%" border="1">
<tr>
<th>ID</th><th>Product Name</th><th>Product Cost</th><th>Image</th><th>Action</th>
</tr>
<c:forEach items="${productList}" var="c">
<tr><td>${c.productId}</td>
<td>${c.productName }</td>
<td>${c.productCost }</td>
<td>${c.categoryId }</td>
<td><img src="${pageContext.request.contextPath}/resources/images/${c.productId}.jpg" style="height:200px;width:200px;"/></td>
<td><a href="<c:url value='/updateProduct/${c.productId }'/>">Edit/<a href="<c:url value='/deleteProduct/${c.productId}'/>">Delete</a></a>
</tr>
</c:forEach>

</table>
</c:if>

</body>
</html>