<!DOCTYPE html>
<html lang="en">
<head>
  <title>BIKES POWERPARTS</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="header.jsp" />
<jsp.include page="product.jsp"/>
<jsp.include page="powerwear.jsp"/>

<div class="container">
  <h2>__</h2>
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
      <li data-target="#myCarousel" data-slide-to="3"></li>
      
    </ol>
   
    <!-- Wrapper for slides -->
    <div class="carousel-inner">
		      <div class="item active">
 
        <img src="resources/images/offroad-2018jumbotron.jpg" alt="KTM" style="width:100%;">
        <img src="resources/images/ktm-orange-cup---home-page-tile-720x720.jpg" alt="KTM" style="width:100%;">
        <img src="resources/images/feature-vision-adventure-starts.jpg" alt="KTM" style="width:100%;">
        <div class="carousel-caption">
          <h3>KTM FACTORY RACER</h3>
          <p>KEEP CALM AND RIDE KTM!</p>
        </div>
         </div>

      <div class="item">
        <img src="resources/images/873824.jpg" alt="enfield" style="width:100%;">
        <img src="resources/images/NYevent-2014-1.jpg" alt="enfield" style="width:100%;">
        <img src="resources/images/continentalGT_slant-front_red_600x463_motorcycle.png" alt="enfield" style="width:100%;">
        <img src="resources/images/biker-royal-enfield-classic-350.jpg" alt="enfield" style="width:100%;">
        <div class="carousel-caption">
          <h3>I NEVER LOSE.I ONLY RUN OUT OF LAPS,GAS,OR TIME. </h3>
          <p>Thank you, Chicago!</p>
        </div>
      </div>
    
      <div class="item">
        <img src="resources/images/Harley-Davidson.svg.png" alt="Harley" style="width:100%;">
        <img src="resources/images/Harley-Davidson-Street-750-Captian-America-Breakout-2-web.jpg" alt="Harley" style="width:100%;">
        <img src="resources/images/4.jpg" alt="Harley" style="width:100%;">
        <img src="resources/images/2014_Harley-Davidson_Street_750_showroom_side.jpg" alt="Harley" style="width:100%;">
        <img src="resources/images/harley-davidson-1905281_1920.jpg" alt="Harley" style="width:100%;">
        <div class="carousel-caption">
          <h3>NO RAIN.NO TRAFFIC. NO WORRIES.</h3>
          <p>!</p>
        </div>
      </div>
  
    </div>
   
    

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>

</body>
</html>

