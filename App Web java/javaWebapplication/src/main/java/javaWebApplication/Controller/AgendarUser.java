package javaWebApplication.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javaWebApplication.Beans.RecordId;

import javaWebApplication.Model.UserDb;

/**
 * Servlet implementation class AgendarUser
 */
@WebServlet("/AgendarUser")
public class AgendarUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AgendarUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

		String atendente = request.getParameter("atendente");
		String servico = request.getParameter("servico");
		String dia = request.getParameter("dia");
		String hora = request.getParameter("hora");

		int atendenteId = mapAtendente(atendente);
		int servicoId = mapServico(servico);
		int diaId = mapDia(dia);
		int horaId = mapHora(hora);

		if (atendenteId == -1 || servicoId == -1 || diaId == -1 || horaId == -1) {
			response.setContentType("text/plain");
			response.getWriter().write("Parâmetros inválidos.");
			return;
		}

		RecordId user = new RecordId(atendenteId, diaId, horaId, servicoId);

		UserDb userDb = new UserDb();
		userDb.insertRecord(user);

		response.setContentType("text/plain");
		response.getWriter().write("Agendamento realizado com sucesso!");

	}

	private int mapAtendente(String atendente) {
		switch (atendente) {
		case "Oreia Cortes":
			return 1;
		case "Cadu Soares":
			return 2;
		case "Kauane Faria":
			return 3;
		case "Daniela farnezi":
			return 4;
		case "Jonas cortes":
			return 5;
		default:
			return -1;
		}
	}

	private int mapServico(String servico) {
		switch (servico) {
		case "Corte de Cabelo":
			return 1;
		case "Barba":
			return 2;
		case "Corte e Barba":
			return 3;
		case "Coloração de Cabelo":
			return 4;
		case "Lavagem":
			return 5;
		default:
			return -1;
		}
	}

	private int mapDia(String dia) {
		switch (dia) {
		case "Segunda":
			return 1;
		case "Terça":
			return 2;
		case "Quarta":
			return 3;
		case "Quinta":
			return 4;
		case "Sexta":
			return 5;
		default:
			return -1;
		}
	}

	private int mapHora(String hora) {
		switch (hora) {
		case "08:00:00":
			return 1;
		case "09:00:00":
			return 2;
		case "10:00:00":
			return 3;
		case "11:00:00":
			return 4;
		case "12:00:00":
			return 5;
		default:
			return -1;
		}
	}
}
