package br.com.transpobrasil.controller;

import java.util.List;
import br.com.transpobrasil.regras.RegrasNegocio;
import br.com.transpobrasil.model.dao.ItemDAO;
import br.com.transpobrasil.model.dao.LancamentoDAO;
import br.com.transpobrasil.model.entity.Item;
import br.com.transpobrasil.model.entity.Lancamento;

public class Controller {

	ItemDAO ItemDAO = new ItemDAO();
	LancamentoDAO daoLancamento = new LancamentoDAO();
	RegrasNegocio regras = new RegrasNegocio();


	/**
	 * Salva os Itens no banco
	 * @param itemOb
	 */
	public void saveItem(Item itemOb) {
		ItemDAO.save(itemOb);
	}


	/**
	 * Editar os Itens no banco através de um ID
	 * @param item
	 */
	public void editarItem(Item item) {
		ItemDAO.editarItem(item);
	}


	/**
	 * Busca todos os os Itens no banco
	 * @return
	 */
	public List<Item> BuscarListaItens() {
		List<Item> lista = ItemDAO.BuscarListaItens();
		return lista;
	}


	/**
	 * Efetua Lançamento dos respectivos itens selecionados
	 * @param lancamentoOb
	 * @param itensSelecionados
	 * @return
	 */
	public double saveLancamento(Lancamento lancamentoOb, List<Item> itensSelecionados) {
		return regras.saveLancamento(lancamentoOb, itensSelecionados);
	}


	/**
	 * Busca a lista de Lançamentos dos Itens no banco
	 * @return lista de lançamentos
	 */
	public List<Lancamento> consultLancamentos() {
		return daoLancamento.BuscarListaLancamentos();
	}


	/**
	 * Efetua uma consulta de interseção entre dois parâmetros
	 * @return String da análise
	 */
	public String intersecao(Integer[] faixa) {
		return regras.analisarIntersecao(faixa);
	}


	/**
	 * Efetua uma consulta de números primos em um intervalo
	 * @param listaPrimos é o intervalo de varredura
	 * @return lista de numeros primos
	 */
	public List<Integer> verificaPrimos(Integer[] listaPrimos) {
		return regras.verificaPrimos(listaPrimos);
	}

}
