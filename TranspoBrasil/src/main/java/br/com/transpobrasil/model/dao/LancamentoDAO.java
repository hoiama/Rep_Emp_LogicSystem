package br.com.transpobrasil.model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.transpobrasil.model.entity.Item;
import br.com.transpobrasil.model.entity.Lancamento;

public class LancamentoDAO extends DAO {

	
	public void saveLancamento(Lancamento lancamentoOb, List<Item> itensSelecionados) {
		
		EntityManager em = getEm();
		
		try {
			em.getTransaction().begin();
			Lancamento lancamento = lancamentoOb;
			lancamento.setItem(itensSelecionados);
			em.persist(lancamento);
			em.getTransaction().commit();
			em.close();
			
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}



	public List<Lancamento> BuscarListaLancamentos(){
		EntityManager em = getEm();
		em.getTransaction().begin();
		String queryJPQL = "select I from Lancamento I";
		Query query = em.createQuery(queryJPQL);
		List<Lancamento> listaLancados = query.getResultList();	
		em.close();
		return listaLancados;
		
	}
	
	
	
	public void delete(int id) {
		
		EntityManager em = getEm();

		try {
			em.getTransaction().begin();
			Lancamento lancamentoOb = em.find(Lancamento.class, id);
			em.remove(lancamentoOb);
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}
}