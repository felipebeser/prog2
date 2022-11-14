package actions;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Tarefa;

public class InserirTarefa {
	public static void main(String[] args) {
		Tarefa tarefa = new Tarefa();
		tarefa.setDescricao("Estudar para recuperacao de Java");
		tarefa.setFinalizado(true);
		tarefa.setDataFinalizacao(Calendar.getInstance()); 
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");
		
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		
		manager.persist(tarefa);
		
		manager.getTransaction().commit();
		
		System.out.println("Tarefa inserida, ID: " + tarefa.getId());
		
		manager.close();
		factory.close();
		}
}
