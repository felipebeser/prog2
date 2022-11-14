package actions;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Tarefa;

public class BuscarUmaTarefa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");
		
		EntityManager manager = factory.createEntityManager();
		
//		Long id = Long.valueOf(1);
//		Tarefa t1 =  manager.find(Tarefa.class, id);
//		System.out.println(t1.getDescricao());
//		
		String sql = "select t from Tarefa as t where t.finalizado = :paramFinalizado";
		Query query = manager.createQuery(sql);
		query.setParameter("paramFinalizado", true);
		
		List<Tarefa> lista = (List<Tarefa>)query.getResultList();
		
		for(Tarefa t: lista) {
			System.out.println(t.getDescricao());
		}
		
		
		
		
		
		
		manager.close();
		factory.close();
	}

}
