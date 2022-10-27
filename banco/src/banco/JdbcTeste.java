package banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcTeste {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/teste";
		String user = "root";
		String password = "";
		Connection con;
		
		try {
			con = DriverManager.getConnection(url, user, password);
			System.out.println("Conectado ao DB.");
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch blocknull
			e.printStackTrace();
		}
	}
}
