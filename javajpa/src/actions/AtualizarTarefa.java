package actions;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Tarefa;

public class AtualizarTarefa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");
		EntityManager manager = factory.createEntityManager();
		Tarefa t1 = manager.find(Tarefa.class, 2L);
		t1.setDescricao("Estudar MAIS para recuperação de Projeto Integrador");
		
		manager.getTransaction().begin();
		manager.merge(t1);
		manager.getTransaction().commit();
		
		System.out.println("Tarefa atualizada.");
		
		manager.close();
		factory.close();
	}

}
