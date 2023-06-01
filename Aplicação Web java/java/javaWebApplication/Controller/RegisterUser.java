package javaWebApplication.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javaWebApplication.Beans.RegisterBean;
import javaWebApplication.Model.UserDb;

/**
 * Servlet implementation class RegisterUser
 */
@WebServlet("/RegisterUser")
public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		PrintWriter out = response.getWriter();
		
		String nome = request.getParameter("nome");
		String sobrenome = request.getParameter("sobrenome");
		String email = request.getParameter("e-mail");
		String password = request.getParameter("senha");
	
		RegisterBean user= new RegisterBean(nome,sobrenome,email,password);
		
		user.setSobreome(sobrenome);
		user.setNome(nome);
		user.setEmail(email);
		BigInteger cript;
		cript = RegisterBean.Criptografarsenha(password);
		user.setSenha(cript.toString());
		
		UserDb userDb = new UserDb();
		
		String s1 = userDb.insertUser(user);
		if(s1.equalsIgnoreCase("Insert concluded")){
		
			response.sendRedirect("http://localhost:8080/javaWebapplication/webapp/jsp/index3.jsp");
		} else {
		out.println("cadastro invalido");
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
