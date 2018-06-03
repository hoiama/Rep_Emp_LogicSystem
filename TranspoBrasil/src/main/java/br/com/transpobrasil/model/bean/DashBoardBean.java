package br.com.transpobrasil.model.bean;

import java.io.Serializable;
import java.util.List;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.RowEditEvent;

import br.com.transpobrasil.controller.Controller;
import br.com.transpobrasil.model.entity.Item;
import br.com.transpobrasil.model.entity.Lancamento;

@ManagedBean(name = "DashBoardBean")
@ViewScoped
public class DashBoardBean  implements Serializable{

	
	private static final long serialVersionUID = 1L;
	private double valorTotal;
	private String respostaIntersecao;
	private Integer[] listaIntervalo = new Integer[4];
	private Integer[] listaPrimos = new Integer[2];
	private List<Integer> numerosPrimos;
	private Item itemOb = new Item();
	private Lancamento lancamentoOb = new Lancamento();
	private List<Item> listaItens;
	private List<Item> listaSelecionados;
	private List<Lancamento> listaLancamentos;
	private List<Lancamento> listaTesteLancamento;
	private List<Item> itensSelecionados;
	Controller serviceController = new Controller();
	
	
	
/*ITENS */
	
	/*Salva os Itens no banco */
	public void saveItem() {
		serviceController.saveItem(itemOb);
		BuscarListaItens();
	}
	
	
	
	/*Editar os Itens no banco */
	public void editarItem (RowEditEvent event){ 
		serviceController.editarItem(((Item) event.getObject()));
	}
	
	
	
	/*Busca todos os os Itens no banco */
	public void BuscarListaItens() {
		List<Item> listaRecebida = (serviceController.BuscarListaItens());
		setListaItens(listaRecebida);
		consultLancamentos();
	}

	
	
	
/*LANÇAMENTOS */
	
	public void saveLancamento() {
		setValorTotal(serviceController.saveLancamento(lancamentoOb, listaSelecionados));
	}
	
	
	
	/*Busca a lista de Lançamentos dos Itens no banco */
	public void consultLancamentos() {	
		setListaLancamentos(serviceController.consultLancamentos());
	}

	
	
	
/* INTERSEÇÂO */
	
	public void intersecao(){
		String resposta = serviceController.intersecao(listaIntervalo);
		setRespostaIntersecao(resposta);
	}
	
	

	
	
/* NÚMEROS PRIMOS */
	
	public void verificaPrimos(){
		setNumerosPrimos(serviceController.verificaPrimos(listaPrimos));
	}
	
	


	
/*GETTER AND SETTER */
	
	public Item getItemOb() {
		return itemOb;
	}

	public void setItemOb(Item itemOb) {
		this.itemOb = itemOb;
	}

	public Lancamento getLancamentoOb() {
		return lancamentoOb;
	}

	public void setLancamentoOb(Lancamento lancamentoOb) {
		this.lancamentoOb = lancamentoOb;
	}

	public List<Item> getListaItens() {
		return listaItens;
	}

	public void setListaItens(List<Item> listaItens) {
		this.listaItens = listaItens;
	}

	public List<Item> getListaSelecionados() {
		return listaSelecionados;
	}

	public void setListaSelecionados(List<Item> listaSelecionados) {
		this.listaSelecionados = listaSelecionados;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Integer[] getListaIntervalo() {
		return listaIntervalo;
	}

	public void setListaIntervalo(Integer[] listaIntervalo) {
		this.listaIntervalo = listaIntervalo;
	}

	public String getRespostaIntersecao() {
		return respostaIntersecao;
	}

	public void setRespostaIntersecao(String respostaIntersecao) {
		this.respostaIntersecao = respostaIntersecao;
	}

	public Integer[] getListaPrimos() {
		return listaPrimos;
	}

	public void setListaPrimos(Integer[] listaPrimos) {
		this.listaPrimos = listaPrimos;
	}


	public List<Lancamento> getListaLancamentos() {
		return listaLancamentos;
	}


	public void setListaLancamentos(List<Lancamento> listaLancamentos) {
		this.listaLancamentos = listaLancamentos;
	}


	public List<Lancamento> getListaTesteLancamento() {
		return listaTesteLancamento;
	}


	public void setListaTesteLancamento(List<Lancamento> listaTesteLancamento) {
		this.listaTesteLancamento = listaTesteLancamento;
	}

	public List<Integer> getNumerosPrimos() {
		return numerosPrimos;
	}

	public void setNumerosPrimos(List<Integer> numerosPrimos) {
		this.numerosPrimos = numerosPrimos;
	}



	public List<Item> getItensSelecionados() {
		return itensSelecionados;
	}



	public void setItensSelecionados(List<Item> itensSelecionados) {
		this.itensSelecionados = itensSelecionados;
	}
	

}
