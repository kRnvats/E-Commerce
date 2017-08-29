<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
     <%@page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
     <meta charset="utf-8">
    <!-- This file has been downloaded from Bootsnipp.com. Enjoy! -->
    <title>Bootstrap NavBar - Bootsnipp.com</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="http://netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet">
    <style type="text/css">
        @media (min-width: 767px) {
    .navbar-nav .dropdown-menu .caret {
	transform: rotate(-90deg);
    }
}

    </style>
    <script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
    <script src="http://netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
</head>
<body>
<style>
            body {
                padding-top: 50px;
            }
            .navbar-template {
                padding: 40px 15px;
            }

        </style>
        <div class="navbar navbar-default navbar-fixed-top" role="navigation">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="brand">BRAND</a>
                </div>
                <div class="collapse navbar-collapse">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="${pageContext.request.contextPath }/">HOME</a></li>
                        
                         <sec:authorize access="hasRole('ROLE_ADMIN')">
                        
                        <li><a href="${pageContext.request.contextPath }/admin/product" >PRODUCT</a></li>
                        <li><a href="${pageContext.request.contextPath }/admin/category">CATEGORY</a></li>
                        
                        </sec:authorize>
                          <sec:authorize access="hasRole('ROLE_USER')">
                        <li>
                            <a href="powerparts" class="dropdown-toggle" data-toggle="dropdown">CATEGORIES <b class="caret"></b></a>

                            <ul class="dropdown-menu">
                            <c:forEach items="${catList}" var="c">
                    	    <li ><a href="${pageContext.request.contextPath }/products/${c.categoryID}">${c.categoryName}</a></li>
                         </c:forEach>
                      	        
                                </ul>
                                             
                                   
                                   </sec:authorize>
    <sec:authorize access="isAnonymous()">                                   
                                     <li>
                            <a href="powerparts" class="dropdown-toggle" data-toggle="dropdown">POWERPARTS <b class="caret"></b></a>

                            <ul class="dropdown-menu">
                            <c:forEach items="${catList}" var="c">
                    	    <li ><a href="${pageContext.request.contextPath }/products/${c.categoryID}">${c.categoryName}</a></li>
                         </c:forEach>
                      	        
                                </ul>
                                            </sec:authorize>
                                 
                              </ul>
                          <ul class="nav navbar-nav navbar-right">
                        <sec:authorize access="isAnonymous()">
                        
                        <li><a href="#" target="_blank">SEARCH</a></li>
                        <li><a href="register" target="_blank">REGISTER</a></li>
                        <li><a href="login">LOGIN</a></li>
                       </sec:authorize>
                       
                        <sec:authorize access="isAuthenticated()"> 
           
                    <li><a href="#" target="_blank">  Hey ${pageContext.request.userPrincipal.name}</a></li>
  <li><a href="${pageContext.request.contextPath }/LogOut">Logout <span class="sr-only">(current)</span></a></li>
                       
                       </sec:authorize>
                       
                      
                       <sec:authorize access="hasRole('ROLE_USER')"> 
         
              	<li> <a href="${pageContext.request.contextPath}/myCart/all"><span class="glyphicon glyphicon-shopping-cart"></span><span class="badge badge-pill badge-primary">${numberProducts }</span></a></li>
         
         </sec:authorize>
          </ul>
                </div><!--/.nav-collapse -->
                
            </div>
        
        </div>
        							
        <script type="text/javascript">
$(document).ready(function() {
    $('.navbar a.dropdown-toggle').on('click', function(e) {
        var $el = $(this);
        var $parent = $(this).offsetParent(".dropdown-menu");
        $(this).parent("li").toggleClass('open');

        if(!$parent.parent().hasClass('nav')) {
            $el.next().css({"top": $el[0].offsetTop, "left": $parent.outerWidth() - 4});
        }

        $('.nav li.open').not($(this).parents("li")).removeClass("open");

        return false;
    });
});

</script>
</body>
</html>
