package actions;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Tarefa;

public class BuscarTodasTarefas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createQuery("SELECT t FROM Tarefa t");
		List<Tarefa> tarefas = (List<Tarefa>)query.getResultList();
		
		for(Tarefa tarefa: tarefas) {
			System.out.println(tarefa.getDescricao());
		}
		
		manager.close();
		factory.close();
	}

}
