const buttonAlterar = document.querySelector('.buttonAlterar');
const modal = document.getElementById('modal');
const closeBtn = document.querySelector('.close');
const buttonAlterarAgendamento = document.querySelector('#buttonAlterarAgendamento');

function checkAuthentication() {
    const isAuthenticated = sessionStorage.getItem("username");
    if (!isAuthenticated) {
        window.location.href = "index.jsp"; // Redirecionar para a página de login
    }
}
closeBtn.addEventListener('click', function() {
	modal.style.display = 'none';
});


window.addEventListener('click', function(event) {
	if (event.target == modal) {
		modal.style.display = 'none';
	}
});

buttonAlterar.addEventListener('click', function(event) {
	selectedAgendamento = getSelectedAlterarAgendamento();

	if (selectedAgendamento != null) {

		console.log(selectedAgendamento);
		modal.style.display = 'block';
		getOptions();

	} else {
		event.preventDefault();
		alert('Selecione um item da tabela antes de abrir o modal.');

	}
});

buttonAlterarAgendamento.addEventListener('click', function() {
	alterarAgendamento(selectedAgendamento);
})


$(document).ready(function() {

	getOptions();
	setAgendamento();
	getAgendamentos();
});



//requests

function setAgendamento() {
	$("#button")
		.click(

			function(event) {
				event.preventDefault();

				var atendente = $("#selectOpcoesAtendente")
					.val();
				var servico = $("#selectOpcoesServico").val();
				var dia = $("#selectOpcoesDia").val();
				var hora = $("#selectOpcoesHora").val();

				let data = {
					atendente: atendente,
					servico: servico,
					dia: dia,
					hora: hora
				};
				$
					.ajax({
						url: "http://localhost:8080/javaWebapplication/AgendarUser",
						type: "POST",
						data: data,
						success: function() {
							console
								.log("Agendamento realizado com sucesso!");
							getAgendamentos();
						},
						error: function(error) {
							console
								.log("Erro na chamada do servlet: "
									+ error);
						}
					});
			});
}

function getAgendamentos() {
	$
		.ajax({
			url: "http://localhost:8080/javaWebapplication/AgendamentoUser",
			type: "GET",
			dataType: "html",
			success: function(response) {
				// Atualizar a div com os dados recebidos do servlet
				$("#tabela").html(response);

				$("#tabela tr").each(
					function() {
						var idAgendamento = $(this).find(
							"td:first").text();
						$(this).addClass("agendamento-item");
						$(this).attr("data-id", idAgendamento);
					});

			},
			error: function(error) {
				console.log("Erro na chamada do servlet: " + error);
			}
		});
}

function getOptions() {
	$
		.ajax({
			url: "http://localhost:8080/javaWebapplication/GetOptionsForm",
			type: "GET",
			dataType: "html",
			success: function(response) {
				$("#selectOpcoesAtendente").empty();
				$("#selectOpcoesAtendente").html(response);
				$("#selectOpcoesAtendente1").empty();
				$("#selectOpcoesAtendente1").html(response);
			},
			error: function(error) {
				console.log("Erro na chamada do servlet: " + error);
			}
		});

	$
		.ajax({
			url: "http://localhost:8080/javaWebapplication/GetOptionsFormHora",
			type: "GET",
			dataType: "html",
			success: function(response) {
				$("#selectOpcoesHora").empty();
				$("#selectOpcoesHora").html(response);
				$("#selectOpcoesHora1").empty();
				$("#selectOpcoesHora1").html(response);
			},
			error: function(error) {
				console.log("Erro na chamada do servlet: " + error);
			}
		});



	$
		.ajax({
			url: "http://localhost:8080/javaWebapplication/GetOptionFormData",
			type: "GET",
			dataType: "html",
			success: function(response) {
				$("#selectOpcoesDia").empty();
				$("#selectOpcoesDia").html(response);
				$("#selectOpcoesDia1").empty();
				$("#selectOpcoesDia1").html(response);
			},
			error: function(error) {
				console.log("Erro na chamada do servlet: " + error);
			}
		});



	$
		.ajax({
			url: "http://localhost:8080/javaWebapplication/GetOptionsFormService",
			type: "GET",
			dataType: "html",
			success: function(response) {
				$("#selectOpcoesServico").empty();
				$("#selectOpcoesServico").html(response);
				$("#selectOpcoesServico1").empty();
				$("#selectOpcoesServico1").html(response);
			},
			error: function(error) {
				console.log("Erro na chamada do servlet: " + error);
			}
		});
}





function getSelectedAgendamentos() {
	var selectedAgendamentos = [];
	$(".checkbox-agendamento:checked").each(
		function() {
			selectedAgendamentos.push($(this).closest("tr").attr(
				"data-id"));
		});
	return selectedAgendamentos;
}



// Botão para excluir agendamentos selecionados
$(document).on("click", ".buttonExcluded", function() {
	var selectedAgendamentos = getSelectedAgendamentos();
	if (selectedAgendamentos.length > 0) {
		excluirAgendamento(selectedAgendamentos);
		console.log(selectedAgendamentos);
	} else {
		alert("Selecione pelo menos um agendamento para excluir.");
	}
});
function excluirAgendamento(idAgendamento) {

	$
		.ajax({
			url: 'http://localhost:8080/javaWebapplication/excluirAgendamento',
			type: 'POST',
			data: {
				id: idAgendamento
			},
			traditional: true, // Define traditional como true para enviar array corretamente
			success: function(response) {
				alert(response);
				getAgendamentos();
			},
			error: function(error) {
				console.log("Erro na chamada do servlet: " + error);
			}
		});
}

function getSelectedAlterarAgendamento() {
	var selectedAgendamento = null;
	var checkboxSelecionado = document.querySelector('.checkbox-agendamento:checked');

	if (checkboxSelecionado) {
		selectedAgendamento = checkboxSelecionado.closest('tr').getAttribute('data-id');
	}

	return selectedAgendamento;
}

function alterarAgendamento(idAgendamento) {
	let novoAtendente = $("#selectOpcoesAtendente1").val();
	let novoServico = $("#selectOpcoesServico1").val();
	let novoDia = $("#selectOpcoesDia1").val();
	let novoHora = $("#selectOpcoesHora1").val();


	idAgendamento = parseInt(idAgendamento);

	$.ajax({
		url: 'http://localhost:8080/javaWebapplication/alterarAgendamento',
		type: 'POST',
		data: {
			id: idAgendamento,
			novoAtendente: novoAtendente,
			novoServico: novoServico,
			novoDia: novoDia,
			novoHora: novoHora
		},
		success: function() {

			getAgendamentos();
		},
		error: function(error) {
			console.log("Erro na chamada do servlet: " + error);
		}
	});
}

