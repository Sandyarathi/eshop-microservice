$(function () {
    "use strict";	
	
	function fetchProducts(firstTime) {
	     $.ajax({
	                url: "http://localhost:8086/gateway/product/all",
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
                       "<div class='col-sm-3 product-name'>" + product.productName + "</div>" +
                       "<div class='col-sm-3'>" + product.productPrice + "</div>" +
				   	   "<div class='col-sm-3'>" + product.description + "</div>" +
				   	   "<div class='col-sm-3'>" + product.category + "</div>" +
                       "</li>");
                });
     }
	   
	fetchProducts(true);
});
		
