package actions;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Tarefa;

public class RemoverTarefa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");
		EntityManager manager = factory.createEntityManager();
		
		Tarefa t1 = manager.find(Tarefa.class, 1L);
		
		manager.getTransaction().begin();
		manager.remove(t1);
		manager.getTransaction().commit();
		
		System.out.println("Tarefa excluída.");
		manager.close();
		factory.close();
	}

}
