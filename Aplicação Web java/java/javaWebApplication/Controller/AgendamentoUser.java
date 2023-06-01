package javaWebApplication.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javaWebApplication.Beans.Record;
import javaWebApplication.Model.UserDb;

/**
 * Servlet implementation class AgendamentoUser
 */

@WebServlet("/AgendamentoUser")
public class AgendamentoUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AgendamentoUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserDb db = new UserDb();
		List<Record> records = db.getRecordsFromDatabase();
		request.setAttribute("records", records);
		forwardToPage(request, response, records);
	
		
	
	
	}
	private void forwardToPage(HttpServletRequest request, HttpServletResponse response, List<Record> records)
			throws ServletException, IOException {
	
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		if (records != null && !records.isEmpty()) {
			for (Record record : records) {
				out.println("<tr>");
				out.println("<td>" + record.getAtendente() + "</td>");
				out.println("<td>" + record.getDiaSemana() + "</td>");
				out.println("<td>" + record.getHoraDia() + "</td>");
				out.println("<td>" + record.getTipoServico() + "</td>");
				out.println("<td>" + record.getPreco() + "</td>");
				out.println("</tr>");
				
			}
		} else {
			out.println("<p>Nenhum agendamento encontrado.</p>");
		}
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	
	
	
	
	}

}
