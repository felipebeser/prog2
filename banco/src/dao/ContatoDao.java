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
	
	public void printContatos(List<Contato> contatos) {
		for(Contato contato: contatos) {
			System.out.println("Nome: " + contato.getNome());
			System.out.println("Endereco: " + contato.getEndereco());
			System.out.println("Email: " + contato.getEmail());
			System.out.println("ID: " + contato.getId()+"\n");
		}
	}
	
	public void adiciona(Contato contato) throws SQLException {
		String sql_insert = "INSERT INTO contatos (nome, email, endereco) VALUES (?, ?, ?)";
		PreparedStatement stmt = con.prepareStatement(sql_insert);
		stmt.setString(1, contato.getNome());
		stmt.setString(2, contato.getEmail());
		stmt.setString(3, contato.getEndereco());
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
		printContatos(contatos);
		rset.close();
		stmt.close();
		return contatos;
	}
	
	public List<Contato> getListaPorLetra() throws SQLException{
		List<Contato> contatos = new ArrayList<Contato>();
		String sql_select_like = "SELECT * FROM contatos WHERE nome LIKE ?";
		PreparedStatement ps = con.prepareStatement(sql_select_like);
		Scanner sc = new Scanner(System.in);
		System.out.println("--- Busca contato por letra inicial ---");
		System.out.println("Digite a letra:");
		char c = sc.next().charAt(0);
		String parameter = c + "%";
		sc.close();
		ps.setString(1, parameter);
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
	
	public Contato getContatoPorId(Long id) throws SQLException{
		Contato contato = new Contato();
		String sql_select_id = "SELECT * FROM contatos WHERE id = ?";
		PreparedStatement ps = con.prepareStatement(sql_select_id);
		System.out.println("--- Busca contato pelo id ---");
		ps.setString(1, Long.toString(id));
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			contato.setNome(rs.getString("nome"));
			contato.setEmail(rs.getString("email"));
			contato.setEndereco(rs.getString("endereco"));
			contato.setId(rs.getLong("id"));
		}
		else {
			System.out.println("Nenhum contato encontrado.");
		}
		return contato;
	}
	
	//item I: remover um contato pelo id
	public void deleta(Long id) throws SQLException {
		String string_delete_contato = "delete from contatos where id = ?";
		PreparedStatement ps = con.prepareStatement(string_delete_contato);
		ps.setString(1, Long.toString(id));
		ps.execute();
		System.out.println("Contato deletado.");
	}
	
	// item H: atualizar nome e/ou email e/ou endereco
	public void atualiza(Contato contato) throws SQLException{
		String sql_update = "UPDATE contatos SET ? = ? WHERE id = ?";
		PreparedStatement ps = con.prepareStatement(sql_update);
		Scanner cs = new Scanner(System.in);
		
	}
	
	
}
