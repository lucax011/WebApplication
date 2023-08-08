$(document).ready(function() {
    $("form").submit(function(e) {
        e.preventDefault();

        var email = $("#e-mail").val();
        var senha = $("#senha").val();

        let data = {
            "e-mail": email,
            senha: senha
        };

        $.ajax({
            url: "http://localhost:8080/javaWebapplication/LoginUser",
            type: "POST",
            data: data,
            success: function(response) {
                if (response.success) {
                    console.log("Usuário autenticado");
                    sessionStorage.setItem("username", email);
                    window.location.replace("index4.jsp"); 
                } else {
                    showError(response.message);
                }
            },
            error: function(jqXHR, textStatus, errorThrown) {
                showError("Erro na chamada do servlet: " + errorThrown);
            }
        });
    });
});

function showError(message) {
    var errorElement = $("<p>").addClass("error-message").text(message);
    $(".error-container").empty().append(errorElement);
}
