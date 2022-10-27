package banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	Connection con;
	
	public static Connection getConnection() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/teste";
		String user = "root";
		String password = "";
		return DriverManager.getConnection(url, user, password);
	}
}
