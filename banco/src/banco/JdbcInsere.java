package banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JdbcInsere {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			String sql_insert = "INSERT INTO contatos (nome, email, endereco) VALUES (?, ?, ?)";
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql_insert);
			Scanner sc = new Scanner(System.in);
			System.out.println("--------- INSERIR CONTATO ---------");
			System.out.println("Digite o nome do contato: ");
			stmt.setString(1, sc.nextLine());
			System.out.println("Digite o email do contato: ");			
			stmt.setString(2, sc.nextLine());
			System.out.println("Digite o endereÃ§o do contato: ");
			stmt.setString(3, sc.nextLine());
			stmt.execute();
			System.out.println("Gravação efetuada com sucesso!");
			sc.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
