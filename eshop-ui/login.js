$(function() {
    "use strict";

    $("#login-form").on('submit', function(event) {
        event.preventDefault();
        $.ajax({
            url: "http://ec2-52-53-167-111.us-west-1.compute.amazonaws.com:8086/gateway/customer/auth",
            type: "POST",
            headers: {
                'Content-Type': 'application/json'
            },
            data: JSON.stringify({
                email: $('#emailaddress').val(),
                password: $('#password').val()
            })
        }).done(function(response) {
            alert("Login Successful!")
            window.location.href = "homepage.html";
        }).fail(function(response) {
            switch (response.status) {
                case 401:
                    alert("Incorrect credentials. Please try again");
                    break;
                case 400:
                    $.notify('Bad Request. Missing required fields', 'error');
                    break;
                default:
                    $.notify('Internal Server Error, failed to login. Please try again.', 'error');
            }
        });
    });
});
