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
		
		
		String atendente = request.getParameter("atendente");
	    String servico = request.getParameter("servico");
	    String dia = request.getParameter("dia");
	    String hora = request.getParameter("hora");
		int atendenteId;
		int servicoId;
		int diaId;
		int horaId = 0;
	    
	    if (atendente.equals("Oreia Cortes")) {
	        atendenteId = 1;
	    } else if (atendente.equals("Cadu Soares")) {
	        atendenteId = 2;
	    } else if (atendente.equals("Kauane Faria")) {
	        atendenteId = 3;
	    } else if (atendente.equals("Daniela farnezi")) {
	        atendenteId = 4;
	    } else if (atendente.equals("Jonas cortes")) {
	        atendenteId = 5;
	    } else {
	      
	        atendenteId = -1; 
	    }
	   
	    if (servico.equals("Corte de Cabelo")) {
	        servicoId = 1;
	    } else if (servico.equals("Barba")) {
	        servicoId = 2;
	    } else if (servico.equals("Corte e Barba")) {
	        servicoId = 3;
	    } else if (servico.equals("Coloração de Cabelo")) {
	        servicoId = 4;
	    } else if (servico.equals("Lavagem")) {
	        servicoId = 5;
	    } else {
	        
	        servicoId = -1; 
	    }
	    
	    if (dia.equals("Segunda")) {
	        diaId = 1;
	    } else if (dia.equals("Terça")) {
	        diaId = 2;
	    } else if (dia.equals("Quarta")) {
	        diaId = 3;
	    } else if (dia.equals("Quinta")) {
	        diaId = 4;
	    } else if (dia.equals("Sexta")) {
	        diaId = 5;
	    } else {
	        
	        diaId = -1; 
	    }
	    
	    if (hora.equals("08:00:00")) {
	        horaId = 1;
	    } else if (dia.equals("09:00:00")) {
	        horaId = 2;
	    } else if (dia.equals("10:00:00")) {
	        horaId = 3;
	    } else if (dia.equals("11:00:00")) {
	        horaId = 4;
	    } else if (dia.equals("12:00:00")) {
	        horaId = 5;
	    } else {
	        
	        diaId = -1; 
	    }
	    
	    RecordId user= new RecordId(atendenteId, diaId, horaId, servicoId);
	  
	    user.setAtendente(atendenteId);
		user.setDiaSemana(diaId);
		user.setHoraDia(horaId);
		user.setTipoServico(servicoId);
		
		UserDb userDb = new UserDb();
		userDb.updateRecord(user);
		
	    response.setContentType("text/plain");
	    response.getWriter().write("Agendamento realizado com sucesso!");
	
	}

}
