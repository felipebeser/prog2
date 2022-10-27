package banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcInsere {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			String sql_insert = "INSERT INTO contatos (nome, email, endereco) VALUES (?, ?, ?)";
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql_insert);
			stmt.setString(1, "Gabriel");
			stmt.setString(2, "gabriel@gabriel.com");
			stmt.setString(3, "Av. Brasil, 10000");
			stmt.execute();
			System.out.println("Gravação efetuada com sucesso!");
			stmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
