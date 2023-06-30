package javaWebApplication.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javaWebApplication.Model.UserDb;

/**
 * Servlet implementation class excluirAgendamento
 */
@WebServlet("/excluirAgendamento")
public class excluirAgendamento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public excluirAgendamento() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    try {
	        UserDb db = new UserDb();
	        String[] idStrings = request.getParameterValues("id");

	        if (idStrings != null && idStrings.length > 0) {
	            int[] ids = new int[idStrings.length];
	            for (int i = 0; i < idStrings.length; i++) {
	                ids[i] = Integer.parseInt(idStrings[i]);
	            }

	            db.deleteRecords(ids);
	            response.getWriter().write("Agendamentos excluídos com sucesso!");
	        } else {
	            response.getWriter().write("IDs de agendamento não fornecidos.");
	        }
	    } catch (NumberFormatException e) {
	        response.getWriter().write("IDs de agendamento inválidos.");
	        e.printStackTrace();
	    }
	}

    }
	
	


