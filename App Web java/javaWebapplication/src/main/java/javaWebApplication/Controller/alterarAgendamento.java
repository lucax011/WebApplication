package javaWebApplication.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javaWebApplication.Beans.RecordIdAlteration;
import javaWebApplication.Model.UserDb;

/**
 * Servlet implementation class alterarAgendamento
 */
@WebServlet("/alterarAgendamento")
public class alterarAgendamento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public alterarAgendamento() {
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
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
		int id= Integer.parseInt(request.getParameter("id"));
		String novoAtendente =request.getParameter("novoAtendente"), 
				novoServico = request.getParameter("novoServico"), 
				novoDia = request.getParameter("novoDia"), 
				novoHora = request.getParameter("novoHora");
		
	 
	    int atendenteId = getAtendenteId(novoAtendente);
        int servicoId = getServicoId(novoServico);
        int diaId = getDiaId(novoDia);
        int horaId = getHoraId(novoHora);
        RecordIdAlteration user = new RecordIdAlteration(id,atendenteId,servicoId,diaId,horaId);
        	
        	UserDb userDb = new UserDb();
	  		userDb.updateRecord(user);
	  		
	  	    response.setContentType("text/plain");
	  	    response.getWriter().write("Agendamento alterado com sucesso!");
	}
	 private int getAtendenteId(String novoAtendente) {
	        int atendenteId;
	        switch (novoAtendente) {
	            case "Oreia Cortes":
	                atendenteId = 1;
	                break;
	            case "Cadu Soares":
	                atendenteId = 2;
	                break;
	            case "Kauane Faria":
	                atendenteId = 3;
	                break;
	            case "Daniela Farnezi":
	                atendenteId = 4;
	                break;
	            case "Jonas Cortes":
	                atendenteId = 5;
	                break;
	            default:
	                atendenteId = -1;
	                break;
	        }
	        return atendenteId;
	    }

	    private int getServicoId(String novoServico) {
	        int servicoId;
	        switch (novoServico) {
	            case "Corte de Cabelo":
	                servicoId = 1;
	                break;
	            case "Barba":
	                servicoId = 2;
	                break;
	            case "Corte e Barba":
	                servicoId = 3;
	                break;
	            case "Coloração de Cabelo":
	                servicoId = 4;
	                break;
	            case "Lavagem":
	                servicoId = 5;
	                break;
	            default:
	                servicoId = -1;
	                break;
	        }
	        return servicoId;
	    }

	    private int getDiaId(String novoDia) {
	        int diaId;
	        switch (novoDia) {
	            case "Segunda":
	                diaId = 1;
	                break;
	            case "Terça":
	                diaId = 2;
	                break;
	            case "Quarta":
	                diaId = 3;
	                break;
	            case "Quinta":
	                diaId = 4;
	                break;
	            case "Sexta":
	                diaId = 5;
	                break;
	            default:
	                diaId = -1;
	                break;
	        }
	        return diaId;
	    }

	    private int getHoraId(String novoHora) {
	        int horaId;
	        switch (novoHora) {
	            case "08:00:00":
	                horaId = 1;
	                break;
	            case "09:00:00":
	                horaId = 2;
	                break;
	            case "10:00:00":
	                horaId = 3;
	                break;
	            case "11:00:00":
	                horaId = 4;
	                break;
	            case "12:00:00":
	                horaId = 5;
	                break;
	            default:
	                horaId = -1;
	                break;
	        }
	        return horaId;
	    }
	}
	


