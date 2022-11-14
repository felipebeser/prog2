package model;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

//DDL
public class GeraInfraDB {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");
		factory.close();
	}
	
}
