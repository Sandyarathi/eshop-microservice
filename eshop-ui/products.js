$(function () {
    "use strict";

	function fetchProducts(firstTime) {
	     $.ajax({
	                url: "http://ec2-52-53-167-111.us-west-1.compute.amazonaws.com:8086/gateway/product/all",
	                type: "GET",
	                'dataType': 'json',
	            }).done(function(response) {
	                !firstTime && $.notify('Meetings list reloaded', 'success');
	                renderProducts(response);
	            }).fail(function(response){
	                $.notify(response.responseText);
	                $('.products > .product').remove();
	            });
	}

    function renderProducts(products) {
               $('.products > .product').remove();
               $.each(products, function(idx, product) {
                    $('.products').append("<li class='row product'>" +
                       "<div class='col-sm-3 product-name'><a href=product.html?productID=" + product.id + ">" + product.productName + "</a></div>" +
                       "<div class='col-sm-3'>" + product.productPrice + "</div>" +
				   	   "<div class='col-sm-3'>" + product.description + "</div>" +
				   	   "<div class='col-sm-3'>" + product.category + "</div>" +
                       "</li>");
                });
     }

	fetchProducts(true);
});
