package br.com.bdd.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Representa o carrinho de compras.
 */
public class Carrinho implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<CarrinhoItem> items = new ArrayList<>();

	/**
	 * Calcula o valor de todos os produtos que estão no carrinho.
	 * 
	 * @return Valor de todos os produtos que estão no carrinho.
	 */
	public double valorTotal() {
		double total = 0d;
		for (CarrinhoItem item : this.items) {
			total = item.getProduto().getPreco() * item.getQuantidade();
		}
		return total;
	}

	/**
	 * Adiciona um produto ao carrinho.
	 * 
	 * @param produto
	 *            Produto a ser adicionado.
	 * @param qtt
	 *            Quantidade do produto.
	 */
	public void incluirProduto(Produto produto, int qtt) {
		for (CarrinhoItem item : this.items) {
			if (item.getProduto().equals(produto)) {
				item.addQuantidade(qtt);
				return;
			}
		}
		this.items.add(new CarrinhoItem(produto, qtt));
	}



	/**
	 * Obtém a quantidade de produtos que estão no carrinho.
	 * 
	 * @return Quantidade de produtos que estão no carrinho.
	 */
	public int quantidadeProdutos() {
		return this.items.size();
	}

	public List<CarrinhoItem> getItems() {
		return items;
	}

	/**
	 * Representa um item do carrinho (produto + quantidade).
	 */
	public static class CarrinhoItem implements Serializable {
		private static final long serialVersionUID = 1L;
		
		private Produto produto;
		private int qtt;

		public CarrinhoItem(Produto produto, int qtt) {
			this.produto = produto;
			this.qtt = qtt;
		}

		public void addQuantidade(int qtt) {
			this.qtt += qtt;
		}

		public Produto getProduto() {
			return produto;
		}

		public int getQuantidade() {
			return qtt;
		}
	}
}
