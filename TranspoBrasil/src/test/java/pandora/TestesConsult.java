package pandora;



import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.transpobrasil.model.entity.Item;


public class TestesConsult {
	
	
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernatePostgres");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
	

		String queryJPQL = "select I from Item I";
		Query query = em.createQuery(queryJPQL);
		List<Item> lista = query.getResultList();
		for (Item item : lista) {
			System.out.println("os OID são " + item.getDescricao());
		}
		em.getTransaction().commit();
		em.close();
		emf.close();
	}

}
