package javaWebApplication.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javaWebApplication.Beans.HoraDia;
import javaWebApplication.Model.UserDb;

/**
 * Servlet implementation class GetOptionsFormHora
 */
@WebServlet("/GetOptionsFormHora")
public class GetOptionsFormHora extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetOptionsFormHora() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		UserDb db = new UserDb();
		List<HoraDia> records = db.getAllHorasDia();
		request.setAttribute("horas", records);
		forwardToPage(request, response, records);
	}
	private void forwardToPage(HttpServletRequest request, HttpServletResponse response, List<HoraDia> records)
			throws ServletException, IOException {
	
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

	    if (records != null && !records.isEmpty()) {
	        for (HoraDia record : records) {
	        	
	        	out.println("<option>" + record.getNome() + "</option>");

	        }
	    }
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
