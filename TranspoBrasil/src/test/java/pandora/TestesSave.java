package pandora;


import java.util.Arrays;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import br.com.transpobrasil.model.entity.Item;
import br.com.transpobrasil.model.entity.Lancamento;

public class TestesSave {
	
	
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernatePostgres");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		
		Item item2 = new Item();
		item2.setDescricao("Testando Descrição do Item");

		Lancamento lan = new Lancamento();
		lan.setObservacao("testando Obsercação de Lancamento");
		lan.setItem(Arrays.asList(item2));
	
		em.persist(item2);
		em.persist(lan);
		
		
		em.getTransaction().commit();
		em.close();
		emf.close();
	}

}
