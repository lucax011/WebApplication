<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Nubarberia</title>
<link rel="stylesheet" href="../css/style.css">

</head>
<body>


	<header class="header-page">
		<h1 class="header-title">
			<img class=""
				src="../img/Logo-circulo-barbearia-1024x1024-removebg-preview.png"
				alt="">
		</h1>
		<h1 class="header-title">Nubarberia</h1>
	</header>

	<div class="caixa-agendamento">


		<h1>Agende um horário com o cabelereiro</h1>
		<form action="" method="post">

			<div class="intro-content1">
				<label for="">Atendente:</label> <select
					id="selectOpcoesAtendente">
				</select><label for="">Serviço:</label> <select id="selectOpcoesServico">
				</select><label for="">Dia:</label> <select id="selectOpcoesDia">
				</select><label for="">Horário:</label> <select id="selectOpcoesHora">
				</select>
			</div>
			<button class="button" type="submit" id="button">Agendar</button>

		</form>
		<div class="caixa-tabela">
			<table class="">
				<!-- cabeçalho da tabela -->
				<thead class="">
					<!-- linha da tabela -->
					<tr class=" header-table">
						<th id="atendente" class="coluna">Atendente</th>
						<th id="data" class="coluna">Data</th>
						<th id="hora" class="coluna">Hora</th>
						<th id="servico" class="coluna">Serviço</th>
						<th id="preco" class="coluna">Preço</th>
					</tr>
				</thead>


				<!-- corpo da tabela -->
				<tbody id="tabela">

				</tbody>

				<tfoot>
					<tr>
						<td colspan="5" class="footer-table">
							<button class="buttonAlterar">Alterar agendamento</button>
							<button class="buttonExcluded">Excluir agendamento</button>
						</td>

					</tr>
				</tfoot>
			</table>
		</div>
	</div>


	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

	<script type="text/javascript">
		$(document).ready(function() {
			// Fazer a chamada do servlet ao carregar a página
			getOptions();
			getOptions2();
			getOptions3();
			getOptions4();		 
			setAgendamento()
			getAgendamentos();
			
		});
	

		

		 

	function setAgendamento() {
		$("#button").click(function(event) {
	        event.preventDefault(); 

	        
	        var atendente = $("#selectOpcoesAtendente").val();
	        var servico = $("#selectOpcoesServico").val();
	        var dia = $("#selectOpcoesDia").val();
	        var hora = $("#selectOpcoesHora").val();

	     
	        var data = {
	            atendente: atendente,
	            servico: servico,
	            dia: dia,
	            hora: hora
	        };


	        $.ajax({
	            url: "http://localhost:8080/javaWebapplication/AgendarUser",
	            type: "POST",
	            data: data,
	            success: function(response) {
	                console.log("Agendamento realizado com sucesso!");
	            },
	            error: function(xhr, status, error) {
	                console.log("Erro na chamada do servlet: " + error);
	            }
	        });
	    });		
		}

	
		function getAgendamentos() {
			$
					.ajax({
						url : "http://localhost:8080/javaWebapplication/AgendamentoUser",
						type : "GET",
						dataType : "html",
						success : function(response) {
							// Atualizar a div com os dados recebidos do servlet
							$("#tabela").html(response);
						},
						error : function(xhr, status, error) {
							console.log("Erro na chamada do servlet: " + error);
						}
					});
		}

		function getOptions() {
			$
					.ajax({
						url : "http://localhost:8080/javaWebapplication/GetOptionsForm",
						type : "GET",
						dataType : "html",
						success : function(response) {
							$("#selectOpcoesAtendente").empty();
							$("#selectOpcoesAtendente").html(response);
						},
						error : function(xhr, status, error) {
							console.log("Erro na chamada do servlet: " + error);
						}
					});
		}

		function getOptions2() {
			$
					.ajax({
						url : "http://localhost:8080/javaWebapplication/GetOptionsFormHora",
						type : "GET",
						dataType : "html",
						success : function(response) {
							$("#selectOpcoesHora").empty();
							$("#selectOpcoesHora").html(response);
						},
						error : function(xhr, status, error) {
							console.log("Erro na chamada do servlet: " + error);
						}
					});
		}

		function getOptions3() {
			$
					.ajax({
						url : "http://localhost:8080/javaWebapplication/GetOptionFormData",
						type : "GET",
						dataType : "html",
						success : function(response) {
							$("#selectOpcoesDia").empty();
							$("#selectOpcoesDia").html(response);
						},
						error : function(xhr, status, error) {
							console.log("Erro na chamada do servlet: " + error);
						}
					});
		}

		function getOptions4() {
			$
					.ajax({
						url : "http://localhost:8080/javaWebapplication/GetOptionsFormService",
						type : "GET",
						dataType : "html",
						success : function(response) {
							$("#selectOpcoesServico").empty();
							$("#selectOpcoesServico").html(response);
						},
						error : function(xhr, status, error) {
							console.log("Erro na chamada do servlet: " + error);
						}
					});
		}
	</script>



</body>
</html>