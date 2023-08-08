package javaWebApplication.Controller;

import java.io.IOException;
import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import javaWebApplication.Beans.LoginBean;
import javaWebApplication.Beans.RegisterBean;
import javaWebApplication.Model.UserDb;

@WebServlet("/LoginUser")
public class LoginUser extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginUser() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String email = request.getParameter("e-mail");
            String password = request.getParameter("senha");

            LoginBean user = new LoginBean();
            user.setEmail(email);
            BigInteger cript;
            cript = RegisterBean.Criptografarsenha(password);
            user.setSenha(cript.toString());

            System.out.println(user.getEmail());
            System.out.println(user.getSenha());
            UserDb dp = new UserDb();
            ResultSet s1 = dp.autenticacaoUsuario(user);

            // Cria um objeto JSON para a resposta
            JSONObject jsonResponse = new JSONObject();

            if (s1.next()) {
                System.out.println("Usuario encontrado");

                HttpSession session = request.getSession(true);
                session.setAttribute("username", user.getEmail());

                jsonResponse.put("success", true);
                jsonResponse.put("message", "Usuário autenticado com sucesso.");

            } else {
                System.out.println("Usuario não encontrado");

                jsonResponse.put("success", false);
                jsonResponse.put("message", "Credenciais inválidas. Usuário não encontrado.");
            }

            // Define o tipo de conteúdo da resposta como JSON
            response.setContentType("application/json");
            // Escreve a resposta JSON no fluxo de saída
            response.getWriter().write(jsonResponse.toString());

        } catch (SQLException e) {
            System.out.println("Erro ao autenticar usuário: " + e.getMessage());
            e.printStackTrace();

            // Resposta de erro para o cliente em formato JSON
            JSONObject errorResponse = new JSONObject();
            errorResponse.put("success", false);
            errorResponse.put("message", "Ocorreu um erro ao processar a solicitação.");
            response.setContentType("application/json");
            response.getWriter().write(errorResponse.toString());
        }
    }
}
