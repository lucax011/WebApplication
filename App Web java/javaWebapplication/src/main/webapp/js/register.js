$(document).ready(function() {
	registerUser();
});

function registerUser() {
	$("#buttonRegister")
		.click(

			function(e) {
				e.preventDefault();
				var nome = $("#nome").val();
				var sobrenome = $("#sobrenome").val();
				var email = $("#e-mail").val();
				var senha = $("#senha").val();

				let data = {
					nome: nome,
					sobrenome: sobrenome,
					"e-mail": email,
					senha: senha
				};
				$
					.ajax({
						url: "http://localhost:8080/javaWebapplication/RegisterUser",
						type: "POST",
						data: data,
						success: function() {
							console
								.log("Request realizada com sucesso!");
								window.location.href = "index3.jsp";
					

						},
						error: function(error) {
					  alert("Erro na chamada do servlet: " + error);
						}
					});
			});

}