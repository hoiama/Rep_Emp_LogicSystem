package br.com.transpobrasil.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.transpobrasil.model.dao.ItemDAO;
import br.com.transpobrasil.model.dao.LancamentoDAO;
import br.com.transpobrasil.model.entity.Item;
import br.com.transpobrasil.model.entity.Lancamento;

public class Controller {
	
	ItemDAO ItemDAO = new ItemDAO();
	LancamentoDAO daoLancamento = new LancamentoDAO();
	
	
	
/*ITENS */
	
	/*Salva os Itens no banco */
	public void saveItem(Item itemOb){
		ItemDAO.save(itemOb);
	}
	
	
	
	/*Editar os Itens no banco através de um ID */
	public void editarItem(Item item){
		ItemDAO.editarItem(item);
	}
	
	
	
	/*Busca todos os os Itens no banco */
	public List<Item> BuscarListaItens(){
		List<Item> lista = ItemDAO.BuscarListaItens();
		return lista;
	}
	
	
	
	
/*LANÇAMENTOS */
	
	/*Efetua Lançamento dos respectivos itens selecionados*/
	public double saveLancamento(Lancamento lancamentoOb, List<Item> itensSelecionados){
		double valorTotal = 0;
		
		for (Item item : itensSelecionados) {
			double	valor = item.getValor();
			valorTotal = valor + valorTotal;
		} 
		
		lancamentoOb.setVl_total(valorTotal);
		daoLancamento.saveLancamento(lancamentoOb, itensSelecionados);
		return valorTotal;
	}
	
	
	
	/*Busca a lista de Lançamentos dos Itens no banco */
	public List<Lancamento> consultLancamentos(){
	return 	daoLancamento.BuscarListaLancamentos();
	}
	
	
	
	
/*INTERSEÇÃO*/
	
	/*Efetua uma consulta de interseção entre dois parâmetros */
	public String intersecao(Integer[] faixa){
		
		Arrays.sort(faixa, 0, 2);
		Arrays.sort(faixa, 2, 4);

		boolean opcao1 = faixa[2] <= faixa[1] & faixa[0] <= faixa[2];
		boolean opcao2 = faixa[2] <= faixa[0] & faixa[1] <= faixa[3];
		
		if(opcao1 ^ opcao2){
			return "Há interseção";
			
		}else{
			return "Não há inteseção";
		}
		
	}
	
	
	
	
	
/* NÚMEROS PRIMOS */
	
	/*Efetua uma consulta de números primos em um intervalo */
	public List<Integer> verificaPrimos(Integer[] listaPrimos){
		List<Integer> lista = new ArrayList();
		
		for(int valor = listaPrimos[0]; valor <= listaPrimos[1]; valor++){
			
			int contador = 0;
			int u = 1;
			
			for( int i = valor; u <= i; u++){
				
				if(i % u == 0 ){
					contador++;
					System.out.println("Nº " + i + "|" +contador + "º vez" + " Divisor" + u);
				}
			}
			
			if(contador <= 2 & contador!= 1){	
				lista.add(valor);
			}	
		}
		
		lista.forEach(System.out::println);
		return lista;
	}

}
