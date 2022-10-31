package banco;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import dao.ContatoDao;
import model.Contato;

public class TesteUpdate {
	public static void main(String[] args) {
		try {
			ContatoDao cdao = new ContatoDao();
			Contato contato = new Contato();
			Scanner sc = new Scanner(System.in);
			String novoValor;
			System.out.println("--- Editar contato ---");
			System.out.println("Digite o id do contato que gostaria de editar: ");
			contato.setId(Long.parseLong(sc.nextLine()));
			String[] campos = {"nome", "email", "endereco"};
			Map<String, String> parameters = new HashMap<>();
			for(String campo: campos) {
				System.out.println("Digite o novo valor do " + campo);
				novoValor = sc.nextLine();
				parameters.put(campo, novoValor);
			}
			cdao.update(contato, parameters);
			System.out.println("Contato editado!");
			sc.close();
			cdao.closeConnection();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
