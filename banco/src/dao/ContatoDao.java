package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import banco.ConnectionFactory;
import model.Contato;

public class ContatoDao {
	private Connection con;
	
	public ContatoDao() throws SQLException {
		this.con = ConnectionFactory.getConnection();
	}
	
	public void adiciona(Contato contato) throws SQLException {
		String sql_insert = "INSERT INTO contatos (nome, email, endereco) VALUES (?, ?, ?)";
		PreparedStatement stmt = con.prepareStatement(sql_insert);
		stmt.setString(1, contato.getNome());
		stmt.setString(2, contato.getEmail());
		stmt.setString(3, contato.getEndereco());
		stmt.execute();
		stmt.close();
		con.close();
	}
	
	public List<Contato> getLista() throws SQLException{
		String sql_select = "SELECT * FROM contatos";
		PreparedStatement stmt = con.prepareStatement(sql_select);
		ResultSet rset = stmt.executeQuery();
		List<Contato> contatos = new ArrayList<Contato>();
		while(rset.next()) {
			Contato contato = new Contato();
			contato.setNome(rset.getString("nome"));
			contato.setEmail(rset.getString("email"));
			contato.setEndereco(rset.getString("endereco"));
			contato.setId(rset.getLong("id"));
			contatos.add(contato);
		}
		rset.close();
		stmt.close();
		con.close();	
		return contatos;
	}
	
	
	public void deleta(Contato contato) {
		
	}
	
	public void atualiza(Contato contato) {
		
	}
}
