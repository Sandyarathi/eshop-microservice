$(function () {
    "use strict";	

    $("#login-form").on('submit', function (event) {
        event.preventDefault();
        $.ajax({
            url: "http://localhost:8086/gateway/customer/create",
            type: "POST",
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            'dataType': 'json',
            data: JSON.stringify({
                email: $('#emailaddress').val(),
                password: $('#password').val()
            })
        }).done(function(response) {
			window.location.href="homepage.html";
        }).fail(function(response){
            switch(response.status) {
                case 400:
                    $.notify('Bad Request. Missing required fields', 'error');
                    break;
                default:
                    $.notify('Internal Server Error, failed to login. Please try again.', 'error');
            }
        });
    });
});
