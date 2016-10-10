$(function () {
    "use strict";

    $("#registration-form").on('submit', function (event) {
        event.preventDefault();
        $.ajax({
            url: "http://ec2-52-53-167-111.us-west-1.compute.amazonaws.com:8086/gateway/customer/create",
            type: "POST",
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            'dataType': 'json',
            data: JSON.stringify({
                firstName: $('#firstname').val(),
                lastName: $('#lastname').val(),
                email: $('#emailaddress').val(),
                password: $('#password').val()
            })
        }).done(function(response) {
            alert("Successfully registered!");
			window.location.href="homepage.html";
        }).fail(function(response){
            switch(response.status) {
                case 400:
                    $.notify('Bad Request. Missing required fields', 'error');
                    break;
                default:
                    $.notify('Internal Server Error, failed to register. Please try again.', 'error')
            }
        });
    });
});
