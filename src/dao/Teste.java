package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ip = "localhost";
		String url = "jdbc:mysql://"+ip+":3306/dentalclinic";
		Connection con;
		try {
			con = DriverManager.getConnection(url, "root", "maynore");
		
		PreparedStatement pesquisa = con.prepareStatement("SELECT * FROM login");
		
		ResultSet resultado = pesquisa.executeQuery();
	    
		while(resultado.next()) {
			String nome = resultado.getString("login");
			System.out.println(nome);
		}
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
