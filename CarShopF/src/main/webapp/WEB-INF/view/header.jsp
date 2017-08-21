	
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
                        <li class="active"><a href="/">HOME</a></li>
                        <li class="active"><a href="service">SERVICE</a></li>
                        <li><a href="product" target="_blank">PRODUCT</a></li>
                        <li><a href="category" target="_blank">CATEGORY</a></li>
                        <li>
                            <a href="powerparts" class="dropdown-toggle" data-toggle="dropdown">POWERPARTS <b class="caret"></b></a>

                            <ul class="dropdown-menu">
                                <li><a href="powerparts">KTM</a></li>
                                <li><a href="royalpowerparts">ROYAL ENFIELD</a></li>
                                <li><a href="harleypowerparts">HARLEY DAVIDSON</a></li>
                                </ul>
                                             
                                    <li>
                                    <a href="powerwear" class="dropdown-toggle" data-toggle="dropdown">POWERWEAR <b class="caret"></b></a>

                                    <ul class="dropdown-menu">
                                        <li><a href="powerwear"> KTM</a></li>
                                        <li><a href="royalpowerwear"> ROYAL ENFIELD</a></li>
                                        <li><a href="harleypowerwear"> HARLEY DAVIDSON</a></li>
										                                        
                                            </ul>
                        <li class="active"><a href="#"></a></li>
                        <li><a href="#" target="_blank"></a></li>
                        <li><a href="#" target="_blank"></a></li>
                        <li><a href="#" target="_blank"></a></li>
                        <li><a href="#" target="_blank"></a></li>
                        <li><a href="#" target="_blank"></a></li>
                        <li><a href="register" target="_blank">REGISTER</a></li>
                        <li><a href="login" target="_blank">LOGIN</a></li>
                       
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
