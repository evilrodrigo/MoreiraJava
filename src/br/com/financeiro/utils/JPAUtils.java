package br.com.financeiro.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtils {

	public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("moreira");
	
	public EntityManager getEntityManager(){
		return emf.createEntityManager();
	}
}
