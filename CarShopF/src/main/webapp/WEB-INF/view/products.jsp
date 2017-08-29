    <%@ page isELIgnored="false" %>
    
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="sp" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp"></jsp:include>


<table width="50%" border="1">
<tr>
<th>ID</th><th>Product Name</th><th>Product Cost</th><th>Image</th><th>Action</th>
</tr>
<c:forEach items="${proList}" var="p">

<td>${p.productName }</td>
<td>${p.productCost }</td>

<td><img src="${pageContext.request.contextPath}/resources/images/${p.productId}.jpg" style="height:200px;width:200px;"/></td>
<td><a href="${pageContext.request.contextPath}/myCart/addToCart/${p.productId}">ADD TO CART</a>
</tr>
</c:forEach>

</table>
