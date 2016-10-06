$(function () {
    "use strict";	
	
	function fetchProducts(firstTime) {
	     $.ajax({
	                url: "/product-service/api/v1/products",
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
	
    function renderMeetings(products) {
               $('.products > .product').remove();
               $.each(products, function(idx, product) {
                    $('.products').append("<li class='row product'>" +
                       "<div class='col-sm-2 product-name'>" + product.productName + "</div>" +
                       "<div class='col-sm-2'>" + product.productPrice + "</div>" +
                       "</li>");
                });
     }
	   
	fetchProducts(true);
});
		