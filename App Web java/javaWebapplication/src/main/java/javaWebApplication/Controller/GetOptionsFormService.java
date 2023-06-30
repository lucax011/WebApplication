package javaWebApplication.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javaWebApplication.Beans.TipoServico;
import javaWebApplication.Model.UserDb;

/**
 * Servlet implementation class GetOptionsFormService
 */
@WebServlet("/GetOptionsFormService")
public class GetOptionsFormService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetOptionsFormService() {
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
		List<TipoServico> records = db.getAllTiposServico();
		request.setAttribute("services", records);
		forwardToPage(request, response, records);
	}
	private void forwardToPage(HttpServletRequest request, HttpServletResponse response, List<TipoServico> records)
			throws ServletException, IOException {
	
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

	    if (records != null && !records.isEmpty()) {
	        for (TipoServico record : records) {
	        	
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
