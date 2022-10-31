package banco;

import java.sql.SQLException;
import java.util.Scanner;

import dao.ContatoDao;
import model.Contato;

public class TesteInsert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			
			ContatoDao cdao = new ContatoDao();
			Contato contato = new Contato();
			Scanner sc = new Scanner(System.in);
			System.out.println("--------- INSERIR CONTATO ---------");
			System.out.println("Digite o nome do contato: ");
			contato.setNome(sc.nextLine());			
			System.out.println("Digite o email do contato: ");
			contato.setEmail(sc.nextLine());	
			System.out.println("Digite o endereço do contato: ");
			contato.setEndereco(sc.nextLine());
			cdao.insert(contato);
			System.out.println("Gravação efetuada com sucesso!");
			sc.close();
			cdao.closeConnection();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
