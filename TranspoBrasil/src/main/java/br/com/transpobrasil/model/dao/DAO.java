package br.com.transpobrasil.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DAO {

	private static EntityManagerFactory emf;

	public DAO() {
		emf = Persistence.createEntityManagerFactory("HibernatePostgres");
	}

	public EntityManager getEm() {
		return emf.createEntityManager();
	}
}
