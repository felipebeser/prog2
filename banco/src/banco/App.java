package banco;

import java.sql.SQLException;
import java.util.Scanner;

import dao.ContatoDao;
import model.Contato;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Long id;
		try {
			ContatoDao cdao = new ContatoDao();
			char res = 's';
			System.out.println("--- APP CONTATOS ---");
			do {
				System.out.println("l - Listar contatos");
				System.out.println("i - Adicionar contato");
				System.out.println("b - Buscar contatos pela primeira letra");
				System.out.println("c - Buscar contato pelo id");
				System.out.println("d - Deletar contato pelo id");
				System.out.println("s - Sair da aplicacão");
				res = sc.nextLine().charAt(0);
				
				switch(res) {
				case 'l': 
					cdao.getLista();
					break;
				case 'i':
					Contato contato = new Contato();
					System.out.println("Digite o nome do contato: ");
					contato.setNome(sc.nextLine());
					System.out.println("Digite o email do contato: ");			
					contato.setEmail(sc.nextLine());
					System.out.println("Digite o endereço do contato: ");
					contato.setEndereco(sc.nextLine());
					cdao.adiciona(contato);
					break;
				case 'b':
					cdao.getListaPorLetra();
					break;
				case 'c':
					System.out.println("--- Busca contato pelo id ---");
					System.out.println("Digite o id:");
					id = sc.nextLong();
					cdao.getContatoPorId(id);
					break;
				case 'd':
//					contato = cdao.getContatoPorId(id);
					System.out.println("Digite o id do contato: ");
					id = sc.nextLong();
					sc.nextLine();
					System.out.println("Deseja realmente deletar este contato? (s/n)");
					char ans = sc.nextLine().charAt(0);
					if(ans == 's') {
						cdao.deleta(id);
					}
					else {
						System.out.println("Cancelando..");
						break;
					}
					break;
					
				case 's':
					break;
				default:
					System.out.println("Digite uma opcao válida.");
				}
			} while(res != 's');
			System.out.println("App finalizado.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
