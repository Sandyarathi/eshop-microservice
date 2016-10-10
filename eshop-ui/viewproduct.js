$(function () {
    "use strict";

 function init() {
	 var productID = getUrlParameter("productID");
     if(!productID) {
         $.notify('Product ID missing in URL', 'error');
         return;
     }
     $.ajax({
         url: "http://ec2-52-53-167-111.us-west-1.compute.amazonaws.com:8086/gateway/product/" + productID,
         type: "GET",
         headers: {
             'Accept': 'application/json',
             'Content-Type': 'application/json'
         },
         'dataType': 'json'
     }).done(function(response) {
         renderProductDetails(response)
     }).fail(function(response){
         switch(response.status) {
             case 400:
                 $.notify('Bad Request. Missing required fields', 'error');
                 break;
             default:
                 $.notify('Internal Server Error, failed to fetch Product Details. Please try again.', 'error')
         }
     });
 }

 function renderProductDetails(productDetails) {
     $('.product-details').append(
         "<div class='row'>" +
             "<label class='col-sm-3 form-label meeting-name'>Product Name: </label>" +
             "<label class='col-sm-3 value-label'>" + productDetails.productBasicInfo.productName + "</label>" +
         "</div>" +
         "<div class='row'>" +
             "<label class='col-sm-3 form-label meeting-name'>Product Price: </label>" +
             "<label class='col-sm-3 value-label'>" + productDetails.productBasicInfo.productPrice + "</label>" +
         "</div>" +
         "<div class='row'>" +
             "<label class='col-sm-3 form-label meeting-name'>Product Description: </label>" +
             "<label class='col-sm-3 value-label'>" + productDetails.productBasicInfo.description + "</label>" +
         "</div>" +
         "<div class='row'>" +
             "<label class='col-sm-3 form-label meeting-name'>Product Category: </label>" +
             "<label class='col-sm-3 value-label'>" + productDetails.productBasicInfo.category + "</label>" +
         "</div>" +
         "<div class='row'>" +
             "<label class='col-sm-3 form-label meeting-name'>Product Rating: </label>" +
             "<label class='col-sm-3 value-label'>" + productDetails.productRating + "</label>" +
         "</div>" +
         "<div class='row'>" +
             "<label class='col-sm-3 form-label meeting-name'>In Stock: </label>" +
             "<label class='col-sm-3 value-label'>" + productDetails.productInventory + "</label>" +
         "</div>"
     );
 }

function getUrlParameter(sParam) {
    var sPageURL = decodeURIComponent(window.location.search.substring(1)),
            sURLVariables = sPageURL.split('&'),
            sParameterName,
            i;

    for (i = 0; i < sURLVariables.length; i++) {
        sParameterName = sURLVariables[i].split('=');

        if (sParameterName[0] === sParam) {
            return sParameterName[1] === undefined ? true : sParameterName[1];
        }
    }
}

function placeOrder() {
 var productID = getUrlParameter("productID");
    if(!productID) {
        $.notify('Product ID missing in URL', 'error');
        return;
    }
	alert("Write API to place order!")

}


    init();
});
