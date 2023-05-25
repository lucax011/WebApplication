package javaWebApplication.Model;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javaWebApplication.Beans.RegisterBean;

public class UserDb {

	
	public String insertUser(RegisterBean user1) {
		
		ConnectionBd bd = new ConnectionBd();
		Connection con = bd.getCon();
		
		String s1 = null;
		
		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate("INSERT INTO USERS(userNome,userSobrenome,email,senha) values('"+user1.getNome()+"','"+user1.getSobrenome()+"','"+user1.getEmail()+"','"+user1.getSenha()+"')");
			s1 = "Insert concluded";
		
		}catch(SQLException e){
			
			e.printStackTrace();
		}
		return s1;
	}
	
}
