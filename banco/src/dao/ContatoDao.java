package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import banco.ConnectionFactory;
import model.Contato;

public class ContatoDao implements DAO<Contato>{
	
	private Connection con;
	
	public ContatoDao() throws SQLException {
		this.con = ConnectionFactory.getConnection();
	}
	
	@Override
	public Contato get(int id) throws SQLException{
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
		
		rs.close();
		ps.close();
		return contato;
	}
	
	@Override
	public List<Contato> getAll() throws SQLException{
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
	
	public List<Contato> getAllByString(String searchFor) throws SQLException{
		List<Contato> contatos = new ArrayList<Contato>();
		String sql_select_like = "SELECT * FROM contatos WHERE nome LIKE ?";
		PreparedStatement ps = con.prepareStatement(sql_select_like);
		ps.setString(1, searchFor + "%");
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			Contato contato = new Contato();
			contato.setNome(rs.getString("nome"));
			contato.setEmail(rs.getString("email"));
			contato.setEndereco(rs.getString("endereco"));
			contato.setId(rs.getLong("id"));
			contatos.add(contato);
		}
		rs.close();
		ps.close();
		return contatos;
	}
	
	@Override
	public void insert(Contato contato) throws SQLException {
		String sql_insert = "INSERT INTO contatos (nome, email, endereco) VALUES (?, ?, ?)";
		PreparedStatement ps = con.prepareStatement(sql_insert);
		ps.setString(1, contato.getNome());
		ps.setString(2, contato.getEmail());
		ps.setString(3, contato.getEndereco());
		ps.execute();
		ps.close();
	}
	
	@Override
	public void update(Contato contato, Map<String, String> params) throws SQLException {
		if(params.size()>0) {
			String sql_update_begin = "UPDATE contatos SET ";
			String sql_update_end = " WHERE id = " + contato.getId();
			int count = 0;
			for(Map.Entry<String, String> item: params.entrySet()) {
				if(count > 0) {
					sql_update_begin += " , ";
				}
				sql_update_begin += item.getKey() + " = " + "?";
				count++;
			}
			String sql_update = sql_update_begin + sql_update_end;
			PreparedStatement ps = con.prepareStatement(sql_update);
			int psIndex = 1;
			for (Map.Entry<String, String> item: params.entrySet()) {
				ps.setString(psIndex, item.getValue());
				psIndex++;
			}
			ps.execute();
			ps.close();
		}
	}
	
	@Override
	public void delete(Contato contato) throws SQLException {
		String string_delete_contato = "delete from contatos where id = ?";
		PreparedStatement ps = con.prepareStatement(string_delete_contato);
		int id = (int)(long)contato.getId();
		ps.setInt(1, id);
		ps.execute();
		ps.close();
	}
	
	public boolean verify(Contato contato) {
		boolean verified = (contato.getId()!=null ? true : false);
		return verified;
	}
	
	public void closeConnection() throws SQLException {
		this.con.close();
	}
}
