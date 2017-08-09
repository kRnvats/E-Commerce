<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Colourful Tabbed Slider Carousel  - Bootsnipp.com</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet">
    <style type="text/css">
        body
{
    padding-top: 20px;
}
#myCarousel .nav a small
{
    display: block;
}
#myCarousel .nav
{
    background: #eee;
}
.nav-justified > li > a
{
    border-radius: 0px;
}
.nav-pills>li[data-slide-to="0"].active a { background-color: #16a085; }
.nav-pills>li[data-slide-to="1"].active a { background-color: #e67e22; }
.nav-pills>li[data-slide-to="2"].active a { background-color: #2980b9; }
.nav-pills>li[data-slide-to="3"].active a { background-color: #8e44ad; }
    </style>
    <script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
    <script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <div id="myCarousel" class="carousel slide" data-ride="carousel">
        <!-- Wrapper for slides -->
        <div class="carousel-inner">
            <div class="item active">
                 
                <div class="carousel-caption">
                    <h3>
                        Headline</h3>
                    <p>
                         We use our own and third party cookies in order to improve your experience and our service.
                        With the aid of cookies we analyze the typical use pattern of visitors to the website. 
                        Your continued use of our website shall be conclusively deemed acceptance of the use of cookies.
                        For further information please read our Privacy Policy.</p>
                </div>
                <img src="resources/images/header2017.jpg">
            </div>
            <!-- End Item -->
            <div class="item">
                <img src="resources/images/1100.jpg">
                <div class="carousel-caption">
                    <h3>
                        Headline</h3>
                    <p>
                        Royal Enfield is an Indian motorcycle manufacturing company with factories in Chennai, India.
                        Originally a British motorcycle company, Royal Enfield and indigenous Madras Motors, 
                        it is now a subsidiary of Eicher Motors Limited, an Indian automaker. </p>
                </div>
            </div>
            <!-- End Item -->
            <div class="item">
                <img src="resources/images/2017-Harley-Davidson-CVO-Limited4-small.jpg">
                <div class="carousel-caption">
                    <h3>
                        Headline</h3>
                    <p> Harley Davidson is an American motorcycle manufacturer founded in 1903.
 						Having made it through the Great Depression,
  						Davidson has fought hard through the last century to make it one of the most respected names in the motorcycle business</p>
                </div>
            </div>
           
            <!-- End Item -->
        </div>
        <!-- End Carousel Inner -->
        <ul class="nav nav-pills nav-justified">
            <li data-target="#myCarousel" data-slide-to="0" class="active"><a href="#">About<small>KTM</small></a></li>
            <li data-target="#myCarousel" data-slide-to="1"><a href="#">About<small>ROYAL ENFIELD</small></a></li>
            <li data-target="#myCarousel" data-slide-to="2"><a href="#">About<small>HARLEY DAVIDSON</small></a></li>
            
        </ul>
    </div>
    <!-- End Carousel -->
</div>

<script type="text/javascript">
$(document).ready( function() {
    $('#myCarousel').carousel({
    	interval:   4000
	});
	
	var clickEvent = false;
	$('#myCarousel').on('click', '.nav a', function() {
			clickEvent = true;
			$('.nav li').removeClass('active');
			$(this).parent().addClass('active');		
	}).on('slid.bs.carousel', function(e) {
		if(!clickEvent) {
			var count = $('.nav').children().length -1;
			var current = $('.nav li.active');
			current.removeClass('active').next().addClass('active');
			var id = parseInt(current.data('slide-to'));
			if(count == id) {
				$('.nav li').first().addClass('active');	
			}
		}
		clickEvent = false;
	});
});
</script>
</body>
</html>



