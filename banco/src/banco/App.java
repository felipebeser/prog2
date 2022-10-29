package banco;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import dao.ContatoDao;
import model.Contato;

public class App {
	Scanner sc = new Scanner(System.in);
	String res;
	int id;
	int menu = 0;
	Contato contato;
	List<Contato> contatos;
	ContatoDao cdao;
	
	public static void main(String[] args) {
		System.out.println("App Contatos v1.0\n");
		System.out.println("Digite 'help' para ver os comandos.\n");
		
		
		try {
			App app = new App();
			app.opcao();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		switch
	}
	
	public App() throws SQLException {
		cdao = new ContatoDao();
	}
	
	public void printContato(Contato contato) throws InterruptedException {
		System.out.println(contato.toString());
	}
	
	public void printContato(List<Contato> contatos) {
		for(Contato contato: contatos) {
			System.out.println(contato.toString());
		}
	}
	
	public void opcao() throws SQLException {
		
		do {
			if(menu == 1){
				showMenu();
			}
			res = sc.nextLine();
			switch(res) {
				case "1": case "listar": 
					contatos = cdao.getLista();
					printContato(contatos);
					break;
				case "2": case "inserir":
					System.out.println("--- Inserir contato ---");
					Contato newContato = new Contato();
					System.out.println("Digite o nome do contato: ");
					newContato.setNome(sc.nextLine());
					System.out.println("Digite o email do contato: ");			
					newContato.setEmail(sc.nextLine());
					System.out.println("Digite o endereço do contato: ");
					newContato.setEndereco(sc.nextLine());
					cdao.adiciona(newContato);
					break;
				case "3": case "buscar":
					System.out.println("--- Busca contato por letra inicial ---");
					System.out.println("Digite a letra:");
					char letra = sc.nextLine().charAt(0);
					cdao.getListaPorLetra(letra);
					break;
				case "4": case "buscarId":
					System.out.println("--- Busca contato pelo id ---");
					System.out.println("Digite o id:");
					id = sc.nextInt();
					sc.nextLine();
					cdao.getContatoPorId(id);	
					break;
				case "5": case "atualizar":
					System.out.println("--- Atualizar contato ---");
		//			cdao.atualiza(newContato);
					
					break;
					
				case "6": case "deletar":
		//			contato = cdao.getContatoPorId(id);
					System.out.println("Digite o id do contato: ");
					id = sc.nextInt();
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
					
				case "s": case "sair":
					System.out.println("App finalizado.");
					break;
				
				case "menu":
					menu = 1;
					break;
				case "help":
					System.out.println("Comandos:");
					System.out.println("listar - lista todos os contatos");
					System.out.println("buscar - busca contatos");
					System.out.println("buscarId - busca contato pelo id");
					System.out.println("atualizar - atualizar um contato");
					System.out.println("deletar - deletar contato pelo id");
					System.out.println("sair - finaliza a aplicação");
					break;
					
					
				default:
					System.out.println("Digite uma opcao válida.");
			}
		} while(!(res.equals("s") || res.equals("sair")));
	}
	public void showMenu() {
		System.out.println("1 - Listar contatos");
		System.out.println("2 - Adicionar contato");
		System.out.println("3 - Buscar contatos pela primeira letra");
		System.out.println("4 - Buscar contato pelo id");
		System.out.println("5 - Atualizar contato pelo id");
		System.out.println("6 - Deletar contato pelo id");
		System.out.println("s - Sair da aplicacão");
	}
}

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Scanner sc = new Scanner(System.in);
//		int id;
//		Contato contato;
//		List<Contato> contatos;
//		try {
//			ContatoDao cdao = new ContatoDao();
//			String res;
//			do {
//				System.out.println("--- APP CONTATOS ---");
//				System.out.println("Digite 'help' para visualizar os comandos.");
//				System.out.println("1 - Listar contatos");
//				System.out.println("2 - Adicionar contato");
//				System.out.println("3 - Buscar contatos pela primeira letra");
//				System.out.println("4 - Buscar contato pelo id");
//				System.out.println("5 - Atualizar contato pelo id");
//				System.out.println("6 - Deletar contato pelo id");
//				System.out.println("s - Sair da aplicacão");
//				res = sc.nextLine();
//				
//				switch(res) {
//				case "1": case "listar": 
//					contatos= cdao.getLista();
//					printContato(contatos);
//					break;
//				case "2":
//					System.out.println("--- Inserir contato ---");
//					Contato newContato = new Contato();
//					System.out.println("Digite o nome do contato: ");
//					newContato.setNome(sc.nextLine());
//					System.out.println("Digite o email do contato: ");			
//					newContato.setEmail(sc.nextLine());
//					System.out.println("Digite o endereço do contato: ");
//					newContato.setEndereco(sc.nextLine());
//					cdao.adiciona(newContato);
//					break;
//				case "3":
//					System.out.println("--- Busca contato por letra inicial ---");
//					System.out.println("Digite a letra:");
//					char letra = sc.nextLine().charAt(0);
//					cdao.getListaPorLetra(letra);
//					break;
//				case "4":
//					System.out.println("--- Busca contato pelo id ---");
//					System.out.println("Digite o id:");
//					id = sc.nextInt();
//					sc.nextLine();
//					cdao.getContatoPorId(id);	
//					break;
//				case "5":
//					System.out.println("--- Atualizar contato ---");
////					cdao.atualiza(newContato);
//					
//					break;
//					
//				case "6":
////					contato = cdao.getContatoPorId(id);
//					System.out.println("Digite o id do contato: ");
//					id = sc.nextInt();
//					sc.nextLine();
//					System.out.println("Deseja realmente deletar este contato? (s/n)");
//					char ans = sc.nextLine().charAt(0);
//					if(ans == 's') {
//						cdao.deleta(id);
//					}
//					else {
//						System.out.println("Cancelando..");
//						break;
//					}
//					break;
//					
//				case "s": case "sair":
//					break;
//					
//				case "help":
//					System.out.println("Comandos:");
//					System.out.println("listar - lista todos os contatos");
//					System.out.println("buscar - busca contatos");
//					System.out.println("buscarId - busca contato pelo id");
//					System.out.println("sair - finaliza a aplicação");
//					break;
//					
//					
//				default:
//					System.out.println("Digite uma opcao válida.");
//				}
//			} while(!(res.equals("s") || res.equals("sair")));
//			
//			sc.close(); 
//			System.out.println("App finalizado.");
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

