<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page isELIgnored="false" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="sp" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
    <!-- This file has been downloaded from Bootsnipp.com. Enjoy! -->
    <title>Thumbnail Hover without Javascript - Bootsnipp.com</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="http://netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet">
    <style type="text/css">
        body {
  padding-top: 50px;
}
 
.thumbnail {
    position:relative;
    overflow:hidden;
}
 
.caption {
    position:absolute;
    top:-100%;
    right:0;
    background:rgba(66, 139, 202, 0.75);
    width:100%;
    height:100%;
    padding:2%;
    text-align:center;
    color:#fff !important;
    z-index:2;
    -webkit-transition: all 0.5s ease-in-out;
    -moz-transition: all 0.5s ease-in-out;
    -o-transition: all 0.5s ease-in-out;
    -ms-transition: all 0.5s ease-in-out;
    transition: all 0.5s ease-in-out;
}
.thumbnail:hover .caption {
    top:0%;
}
    
    </style>
    <script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
    <script src="http://netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
 <div class="row"> 
 <c:forEach var="c" items="${productList}" begin="40">      
 <div class="col-md-3">            
            <div class="thumbnail">
                <div class="caption">
                    <h4>${c.productName}</h4>
                    <p>&#8377; ${c.productCost }</p>
                    <p><a href="" class="label label-danger">Zoom</a>
                    <a href="${pageContext.request.contextPath }/myCart/addToCart/${c.productId}" class="label label-default">Add To Cart</a></p>
                </div>
                <img style="height:200px;width:200px;"src="${pageContext.request.contextPath }/resources/images/${c.productId }.jpg" alt="...">
            </div>
        </div>
      </c:forEach>
      </div>
      
        <!-- <div class="col-md-3">            
            <div class="thumbnail">
                <div class="caption">
                    <h4>Thumbnail Headline</h4>
                    <p>short thumbnail description</p>
                    <p><a href="" class="label label-danger">Zoom</a>
                    <a href="" class="label label-default">Download</a></p>
                </div>
                <img src="http://lorempixel.com/400/300/sports/2/" alt="...">
            </div>
        </div>

        <div class="col-md-3">            
            <div class="thumbnail">
                <div class="caption">
                    <h4>Thumbnail Headline</h4>
                    <p>short thumbnail description</p>
                    <p><a href="" class="label label-danger">Zoom</a>
                    <a href="" class="label label-default">Download</a></p>
                </div>
                <img src="http://lorempixel.com/400/300/sports/3/" alt="...">
            </div>
        </div>

        <div class="col-md-3">            
            <div class="thumbnail">
                <div class="caption">
                    <h4>Thumbnail Headline</h4>
                    <p>short thumbnail description</p>
                    <p><a href="" class="label label-danger">Zoom</a>
                    <a href="" class="label label-default">Download</a></p>
                </div>
                <img src="http://lorempixel.com/400/300/sports/4/" alt="...">
            </div>  
        </div> 
        <div class="col-md-3">            
            <div class="thumbnail">
                <div class="caption">
                    <h4>Thumbnail Headline</h4>
                    <p>short thumbnail description</p>
                    <p><a href="" class="label label-danger">Zoom</a>
                    <a href="" class="label label-default">Download</a></p>
                </div>
                <img src="http://lorempixel.com/400/300/sports/1/" alt="...">
            </div>
        </div>
      
        <div class="col-md-3">            
            <div class="thumbnail">
                <div class="caption">
                    <h4>Thumbnail Headline</h4>
                    <p>short thumbnail description</p>
                    <p><a href="" class="label label-danger">Zoom</a>
                    <a href="" class="label label-default">Download</a></p>
                </div>
                <img src="http://lorempixel.com/400/300/sports/2/" alt="...">
            </div>
        </div>

        <div class="col-md-3">            
            <div class="thumbnail">
                <div class="caption">
                    <h4>Thumbnail Headline</h4>
                    <p>short thumbnail description</p>
                    <p><a href="" class="label label-danger">Zoom</a>
                    <a href="" class="label label-default">Download</a></p>
                </div>
                <img src="http://lorempixel.com/400/300/sports/3/" alt="...">
            </div>
        </div>

        <div class="col-md-3">            
            <div class="thumbnail">
                <div class="caption">
                    <h4>Thumbnail Headline</h4>
                    <p>short thumbnail description</p>
                    <p><a href="" class="label label-danger">Zoom</a>
                    <a href="" class="label label-default">Download</a></p>
                </div>
                <img src="http://lorempixel.com/400/300/sports/4/" alt="...">
            </div>  
        </div> 
        <div class="col-md-3">            
            <div class="thumbnail">
                <div class="caption">
                    <h4>Thumbnail Headline</h4>
                    <p>short thumbnail description</p>
                    <p><a href="" class="label label-danger">Zoom</a>
                    <a href="" class="label label-default">Download</a></p>
                </div>
                <img src="http://lorempixel.com/400/300/sports/1/" alt="...">
            </div>
        </div>
      
        <div class="col-md-3">            
            <div class="thumbnail">
                <div class="caption">
                    <h4>Thumbnail Headline</h4>
                    <p>short thumbnail description</p>
                    <p><a href="" class="label label-danger">Zoom</a>
                    <a href="" class="label label-default">Download</a></p>
                </div>
                <img src="http://lorempixel.com/400/300/sports/2/" alt="...">
            </div>
        </div>

        <div class="col-md-3">            
            <div class="thumbnail">
                <div class="caption">
                    <h4>Thumbnail Headline</h4>
                    <p>short thumbnail description</p>
                    <p><a href="" class="label label-danger">Zoom</a>
                    <a href="" class="label label-default">Download</a></p>
                </div>
                <img src="http://lorempixel.com/400/300/sports/3/" alt="...">
            </div>
        </div>

        <div class="col-md-3">            
            <div class="thumbnail">
                <div class="caption">
                    <h4>Thumbnail Headline</h4>
                    <p>short thumbnail description</p>
                    <p><a href="" class="label label-danger">Zoom</a>
                    <a href="" class="label label-default">Download</a></p>
                </div>
                <img src="http://lorempixel.com/400/300/sports/4/" alt="...">
            </div>  
        </div> 
    </div>
    
    <div class="row">
        <div class="col-xs-12 text-center">
            Original <a href="http://bootsnipp.com/snippets/featured/thumbnail-caption-hover-effect">Thumbnail Caption Hover Effect</a> by <a href="http://bootsnipp.com/sevenx.de">sevenx.de</a>
        </div>
   </div>-->
  
</div><!-- /.container -->
<script type="text/javascript">

</script>
</body>
</html>
