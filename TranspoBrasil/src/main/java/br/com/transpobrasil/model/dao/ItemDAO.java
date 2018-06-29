package br.com.transpobrasil.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import br.com.transpobrasil.model.entity.Item;

public class ItemDAO extends DAO {

	public void save(Item itemOb) {
		EntityManager em = getEm();
		try {
			em.getTransaction().begin();
			em.persist(itemOb);
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}

	public void editarItem(Item item) {
		EntityManager em = getEm();
		try {
			em.getTransaction().begin();
			Item itemOb = em.find(Item.class, item.getOid());
			em.merge(item);
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
		em.close();
	}

	public void delete(int id) {
		EntityManager em = getEm();
		try {
			em.getTransaction().begin();
			Item itemOb = em.find(Item.class, id);
			em.remove(itemOb);
			em.close();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
		em.close();
	}

	public List<Item> BuscarListaItens() {
		EntityManager em = getEm();
		em.getTransaction().begin();
		String queryJPQL = "select I from Item I";
		Query query = em.createQuery(queryJPQL);
		List<Item> lista = query.getResultList();
		em.close();
		return lista;
	}

}
