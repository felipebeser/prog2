package dao;

import java.sql.SQLException;
import java.util.List;

import model.Contato;

public class JdbcTesteLista {
	public static void main(String[] args) {
		try {
			ContatoDao cdao = new ContatoDao();
			List<Contato> contatos = cdao.getLista();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
