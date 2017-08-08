<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
    <meta charset="utf-8">
    <!-- This file has been downloaded from Bootsnipp.com. Enjoy! -->
    <title>masonry Image Gallery - Bootsnipp.com</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet">
    <style type="text/css">
        body {
    font-family: sans-serif;
}
#container {
    background: #DDD;
    max-width: 1400px;
}
.item {
    width: 200px;
    float: left;
}
.item img {
    display: block;
    width: 100%;
}
button {
    font-size: 18px;
}
.container{
    width:100%;
}
    </style>
    <script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
<h1>Masonry + imagesLoaded, iteratively reveal items</h1>

<div id="container"></div>
<div id="images">
    <div class="item">
        <img src="http://lorempixel.com/425/299/nature">
    </div>
    <div class="item">
        <img src="http://lorempixel.com/190/292/nature">
    </div>
    <div class="item">
        <img src="http://lorempixel.com/520/329/nature">
    </div>
    <div class="item">
        <img src="http://lorempixel.com/404/176/nature">
    </div>
    <div class="item">
        <img src="http://lorempixel.com/530/290/nature">
    </div>
    <div class="item">
        <img src="http://lorempixel.com/228/200/nature">
    </div>
    <div class="item">
        <img src="http://lorempixel.com/207/316/nature">
    </div>
    <div class="item">
        <img src="http://lorempixel.com/435/162/nature">
    </div>
    <div class="item">
        <img src="http://lorempixel.com/376/175/nature">
    </div>
    <div class="item">
        <img src="http://lorempixel.com/508/338/nature">
    </div>
    <div class="item">
        <img src="http://lorempixel.com/404/389/nature">
    </div>
    <div class="item">
        <img src="http://lorempixel.com/216/304/nature">
    </div>
</div>
<p>
    <button id="load-images">Load images</button>
    
    <script src="//masonry.desandro.com/masonry.pkgd.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery.imagesloaded/3.0.4/jquery.imagesloaded.js"></script>
    
    </div>
    
</p>
<script type="text/javascript">
    $(function () {

    var $container = $('#container').masonry({
        itemSelector: '.item',
        columnWidth: 200
    });

    // reveal initial images
    $container.masonryImagesReveal($('#images').find('.item'));
});

$.fn.masonryImagesReveal = function ($items) {
    var msnry = this.data('masonry');
    var itemSelector = msnry.options.itemSelector;
    // hide by default
    $items.hide();
    // append to container
    this.append($items);
    $items.imagesLoaded().progress(function (imgLoad, image) {
        // get item
        // image is imagesLoaded class, not <img>, <img> is image.img
        var $item = $(image.img).parents(itemSelector);
        // un-hide item
        $item.show();
        // masonry does its thing
        msnry.appended($item);
    });

    return this;
};
</script>
</body>
</html>
