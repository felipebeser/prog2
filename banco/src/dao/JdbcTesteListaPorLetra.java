package dao;

import java.sql.SQLException;
import java.util.List;

import model.Contato;

public class JdbcTesteListaPorLetra {
	public static void main(String[] args) {
		try {
			ContatoDao cdao = new ContatoDao();
			List<Contato> contatos = cdao.getListaPorLetra();
			
			for(Contato contato: contatos) {
				System.out.println("Nome: " + contato.getNome());
				System.out.println("Endereco: " + contato.getEndereco());
				System.out.println("Email: " + contato.getEmail());
				System.out.println("ID: " + contato.getId()+"\n");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
