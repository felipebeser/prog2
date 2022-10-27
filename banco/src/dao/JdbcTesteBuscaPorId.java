package dao;

import java.sql.SQLException;
import java.util.List;

import model.Contato;

public class JdbcTesteBuscaPorId {
	public static void main(String[] args) {
		try {
			ContatoDao cdao = new ContatoDao();
//			Contato contato = cdao.getContatoPorId();
////			if(contato.getId()!= null) {
//				System.out.println("Nome: " + contato.getNome());
//				System.out.println("Endereco: " + contato.getEndereco());
//				System.out.println("Email: " + contato.getEmail());
//				System.out.println("ID: " + contato.getId()+"\n");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
