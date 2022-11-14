package cardinalidade;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DoisUmTestaGE {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DoisUmGovernador g1 = new DoisUmGovernador();
		g1.setNome("Governador teste 2 RJ");
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("cardinalidade");
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.persist(g1);
		manager.getTransaction().commit();
		
		DoisUmEstado e1 = new DoisUmEstado();
		e1.setGovernador(g1);
		e1.setNome("Rio de Janeiro");
		e1.setSigla("RJ");
		manager.getTransaction().begin();
		manager.persist(e1);
		manager.getTransaction().commit();
		manager.close();
		factory.close();
	}

}
