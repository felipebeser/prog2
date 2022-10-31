package banco;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import dao.ContatoDao;
import model.Contato;

public class App {
	Scanner sc = new Scanner(System.in);
	String res;
	String ans;
	int id;
	Boolean menuMode = false;
	Contato contato;
	List<Contato> contatos;
	ContatoDao cdao;
	
	public static void main(String[] args) {
		System.out.println("App Contatos v1.0\n");
		System.out.println("Digite 'help' para ver os comandos ou 'menu' para navegar pelo menu simplificado.\n");
		
		try {
			App app = new App();
			app.opcao();
			app.cdao.closeConnection();
		} catch (SQLException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void opcao() throws SQLException, InterruptedException {
		
		do {
			if(menuMode){
				showMenu();
			}
			System.out.print(">");
			res = sc.nextLine().trim();
			System.out.println("");
			
			switch(res) {
				case "1": 
				case "listar": 
					contatos = cdao.getAll();
					printContato(contatos);
					break;
					
				case "2": 
				case "adicionar":
					System.out.println("--- Adicionar contato ---");
					Contato newContato = new Contato();
					System.out.println("Digite o nome do contato: ");
					newContato.setNome(sc.nextLine());
					System.out.println("Digite o email do contato: ");			
					newContato.setEmail(sc.nextLine());
					System.out.println("Digite o endereço do contato: ");
					newContato.setEndereco(sc.nextLine());
					cdao.insert(newContato);
					System.out.println("Gravação efetuada com sucesso!");
					break;
					
				case "3": 
				case "buscar":
					System.out.println("--- Buscar contato ---");
					System.out.println("Digite uma letra ou string: ");
					String searchFor = sc.nextLine();
					contatos = cdao.getAllByString(searchFor);
					if(contatos.size()>0){
						printContato(contatos);
					} else {
						System.out.println("Nenhum contato encontrado.");
					}
					break;
					
				case "4": 
				case "buscarId":
					System.out.println("--- Buscar contato por id ---");
					System.out.println("Digite o id:");
					id = sc.nextInt();
					sc.nextLine();
					contato = cdao.get(id);	
					if(cdao.verify(contato)) {
						printContato(contato);
					} else {
						System.out.println("Contato não encontrado.");
					}
					break;
					
				case "5": 
				case "editar":
					System.out.println("--- Editar contato ---");
					System.out.println("Digite o id do contato que gostaria de editar: ");
					id = Integer.parseInt(sc.nextLine());
					contato = cdao.get(id);
					
					if(cdao.verify(contato)) {
						System.out.println("Editando o contato: ");
						System.out.println(contato.toString());
						String[] campos = {"nome", "email", "endereco"};
						String escolha;
						Map<String, String> parameters = new HashMap<>();
						for(String campo: campos) {
							System.out.println("Deseja editar o campo "+ campo + "? (s/n)");
							escolha = sc.nextLine();
							while(!(escolha.equals("s") || escolha.equals("n"))) {
								System.out.println("Digite s ou n.");
								escolha=sc.nextLine();
							}
							if(escolha.equals("s")) {
								System.out.println("Digite o novo valor do " + campo);
								ans = sc.nextLine();
								parameters.put(campo, ans);
							}	
							if(escolha.equals("n")) {
								continue;
							}
						}
						cdao.update(contato, parameters);
						System.out.println("Contato editado!");
					} else {
						System.out.println("Contado não encontrado");
					}
					break;
					
				case "6": 
				case "deletar":
					System.out.println("--- Deletar contato ---");
					System.out.println("Digite o id do contato: ");
					try {
						id = sc.nextInt();
					} catch (InputMismatchException e){
						System.out.println("É necessário um número inteiro correspondente ao id.\nVoltando ao menu..");
						break;
					}
					sc.nextLine();
					contato = cdao.get(id);
					if(cdao.verify(contato)) {
						System.out.println(contato.toString());
						System.out.println("Deseja realmente deletar este contato? (s/n)");
						ans = sc.nextLine();
						if(ans.equals("s")) {
							cdao.delete(contato);
							System.out.println("Contato deletado.");
						}
						else {
							System.out.println("Cancelando..");
							break;
						}
					} else {
						System.out.println("Contato não encontrado.");
					}
					break;
					
				case "s": 
				case "sair":
					System.out.println("App finalizado.");
					break;
					
				case "menu":
					menuMode = !menuMode;
					break;
					
				case "help":
					showHelp();
					break;
					
				default:
					System.out.println("Entre uma opcao válida.");
					if(!menuMode) {
						System.out.println("Digite 'help' para ver os comandos disponíveis.");
					}
			}
		} while(!(res.equals("s") || res.equals("sair")));
	}
	public void showMenu() {
		System.out.println("\n1 - Listar contatos");
		System.out.println("2 - Adicionar contato");
		System.out.println("3 - Buscar contatos pela primeira letra");
		System.out.println("4 - Buscar contato pelo id");
		System.out.println("5 - Atualizar contato pelo id");
		System.out.println("6 - Deletar contato pelo id");
		System.out.println("s - Sair da aplicação");
	}
	
	public void showHelp() {
		System.out.println("\nlista de comandos:");
		System.out.println("listar - lista todos os contatos");
		System.out.println("adicionar - adiciona um novo contato");
		System.out.println("buscar - busca contatos");
		System.out.println("buscarId - busca contato pelo id");
		System.out.println("editar - atualizar um contato");
		System.out.println("deletar - deletar contato pelo id");
		System.out.println("sair - finaliza a aplicação");
	}
	
	public App() throws SQLException {
		this.cdao = new ContatoDao();
	}
	
	public void printContato(Contato contato) throws InterruptedException {
		System.out.println(contato.toString());
	}
	
	public void printContato(List<Contato> contatos) {
		for(Contato contato: contatos) {
			System.out.println(contato.toString());
		}
	}
}


