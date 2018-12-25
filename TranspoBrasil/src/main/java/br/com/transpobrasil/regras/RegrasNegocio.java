package br.com.transpobrasil.regras;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import br.com.transpobrasil.model.dao.LancamentoDAO;
import br.com.transpobrasil.model.entity.Item;
import br.com.transpobrasil.model.entity.Lancamento;

public class RegrasNegocio {

	LancamentoDAO daoLancamento = new LancamentoDAO();
	
	public String analisarIntersecao(Integer[] faixa) {
		Arrays.sort(faixa, 0, 2);
		Arrays.sort(faixa, 2, 4);
		boolean opcao1 = faixa[2] <= faixa[1] & faixa[0] <= faixa[2];
		boolean opcao2 = faixa[2] <= faixa[0] & faixa[1] <= faixa[3];
		return opcao1 ^ opcao2 ? "Há interseção": "Não há inteseção";
	}

	public List<Integer> verificaPrimos(Integer[] listaPrimos) {
		List<Integer> lista = new ArrayList<Integer>();

		for (int valor = listaPrimos[0]; valor <= listaPrimos[1]; valor++) {
			int contador = 0;
			int u = 1;

			for (int i = valor; u <= i; u++) {
				if (i % u == 0) {
					contador++;
					System.out.println("Nº " + i + "|" + contador + "º vez" + " Divisor" + u);
				}
			}

			if (contador <= 2 & contador != 1) {
				lista.add(valor);
			}
		}

		lista.forEach(System.out::println);
		return lista;
	}

	public double saveLancamento(Lancamento lancamentoOb, List<Item> itensSelecionados) {
		double valorTotal = 0;

		for (Item item : itensSelecionados) {
			double valor = item.getValor();
			valorTotal = valor + valorTotal;
		}

		lancamentoOb.setVl_total(valorTotal);
		daoLancamento.saveLancamento(lancamentoOb, itensSelecionados);
		return valorTotal;
	}
}


