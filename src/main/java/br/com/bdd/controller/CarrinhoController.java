package br.com.bdd.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.bdd.domain.Carrinho;
import br.com.bdd.domain.Carrinho.CarrinhoItem;
import br.com.bdd.domain.Produto;

@ViewScoped
@ManagedBean(name = "carrinhoController")
public class CarrinhoController implements Serializable {

	private static final long serialVersionUID = 1L;

	private Carrinho carrinho = new Carrinho();
	private List<Produto> produtos = new ArrayList<>();
	private int quantidade = 1;
	private Produto produtoSelecionado;

	@PostConstruct
	public void init() {
		this.produtos.add(new Produto("Chrome Cast", 200.00, "1.jpg"));
		this.produtos.add(new Produto("Camera Fotográfica", 1500.0, "2.jpg"));
		this.produtos.add(new Produto("Xbox-360", 555.45, "3.jpg"));
		this.produtos.add(new Produto("Cadeira Office Presidente", 399.99,
				"4.jpg"));
	}

	/**
	 * Adiciona o produto selecionado ao carrinho.
	 */
	public void adicionarProduto() {
		this.carrinho.incluirProduto(this.produtoSelecionado, this.quantidade);
		this.quantidade = 1;
	}

	/**
	 * Remove o produto selecionado do carrinho.
	 */
	public void removerProduto() {
		this.carrinho.removerProduto(this.produtoSelecionado);
	}

	/**
	 * Adiciona o produto ao carrinho.
	 * 
	 * @param p
	 *            Produto a ser adicionado ao carrinho.
	 */
	public void addProduto(Produto p) {
		this.carrinho.incluirProduto(p, this.quantidade);
	}

	/**
	 * Define a quantidade do produto selecionado que será adicionada ao
	 * carrinho.
	 * 
	 * @param quantidade
	 *            Quantidade do produto selecionado que será adicionada ao
	 *            carrinho.
	 */
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	/**
	 * Quantidade do produto selecionado que será adicionada ao carrinho.
	 * 
	 * @return Quantidade do produto selecionado que será adicionada ao
	 *         carrinho.
	 */
	public int getQuantidade() {
		return quantidade;
	}

	/**
	 * Obtém os produtos que serão visualizados.
	 * 
	 * @return Produtos que serão visualizados.
	 */
	public List<Produto> getProdutos() {
		return produtos;
	}

	/**
	 * Obtém o produto selecionado.
	 * 
	 * @return produto selecionado.
	 */
	public Produto getProdutoSelecionado() {
		return produtoSelecionado;
	}

	/**
	 * Define o produto selecionado.
	 * 
	 * @param produtoSelecionado
	 *            Produto selecionado.
	 */
	public void setProdutoSelecionado(Produto produtoSelecionado) {
		this.produtoSelecionado = produtoSelecionado;
	}

	/**
	 * Obtém os items que já estão no carrinho.
	 * 
	 * @return Items que já estão no carrinho.
	 */
	public List<CarrinhoItem> getItemsNoCarrinho() {
		return this.carrinho.getItems();
	}
	
	/**
	 * Obtém o valor total dos produtos que estão no carrinho.
	 * @return Valor total dos produtos que estão no carrinho.
	 */
	public double getTotal() {
		return this.carrinho.valorTotal();
	}

}
