package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
		System.out.println(stmt);
		stmt.setString(1, contato.getNome());
		stmt.setString(2, contato.getEmail());
		stmt.setString(3, contato.getEndereco());
		System.out.println(stmt);
		stmt.execute();
		System.out.println("Gravação efetuada com sucesso!");
		stmt.close();
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
		return contatos;
	}
	
	public List<Contato> getListaPorLetra(char letra) throws SQLException{
		List<Contato> contatos = new ArrayList<Contato>();
		String sql_select_like = "SELECT * FROM contatos WHERE nome LIKE ?";
		PreparedStatement ps = con.prepareStatement(sql_select_like);
		ps.setString(1, letra + "%");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Contato contato = new Contato();
			contato.setNome(rs.getString("nome"));
			contato.setEmail(rs.getString("email"));
			contato.setEndereco(rs.getString("endereco"));
			contato.setId(rs.getLong("id"));
			contatos.add(contato);
		}
		return contatos;
	}
	
	public Contato getContatoPorId(int id) throws SQLException{
		Contato contato = new Contato();
		String sql_select_id = "SELECT * FROM contatos WHERE id = ?";
		PreparedStatement ps = con.prepareStatement(sql_select_id);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			contato.setNome(rs.getString("nome"));
			contato.setEmail(rs.getString("email"));
			contato.setEndereco(rs.getString("endereco"));
			contato.setId(rs.getLong("id"));
		}
		return contato;
	}
	
	//item I: remover um contato pelo id
	public void deleta(int id) throws SQLException {
		String string_delete_contato = "delete from contatos where id = ?";
		PreparedStatement ps = con.prepareStatement(string_delete_contato);
		ps.setString(1, Integer.toString(id));
		ps.execute();
		System.out.println("Contato deletado.");
	}
	
	// item H: editar nome e/ou email e/ou endereco
	public void edita(Contato contato, List<ArrayList<String>> params) throws SQLException {
		if(params.size()>0) {
			int count = 0;
			String sql_update_begin = "UPDATE contatos SET ";
			String sql_update_end = " WHERE id = " + contato.getId();
	
			for(List<String> list: params) {
				if(count > 0) {
					sql_update_begin += " , ";
				}
				sql_update_begin += list.get(0) + " = " + "?";
				count++;
			}
			String sql_update = sql_update_begin + sql_update_end;
			PreparedStatement ps = con.prepareStatement(sql_update);
			int index = 1;
			for (List<String> list: params) {
				ps.setString(index, list.get(1));
				index++;
			}
			ps.execute();
			ps.close();
		}
	}
}
