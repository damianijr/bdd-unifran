package br.com.bdd.tdd;

import junit.framework.TestCase;
import br.com.bdd.domain.Carrinho;
import br.com.bdd.domain.Produto;

public class TestCarrinho1 extends TestCase {

	private Carrinho carrinho = new Carrinho();

	public void test1() {
		this.carrinho.incluirProduto(new Produto("DVD-RW", 3.0d), 2);
		this.carrinho.incluirProduto(new Produto("BLUERAY", 25.5d), 2);
		// Valor esperado é 3*2 + 25.5*2 = 57
		assertEquals(57d, this.carrinho.valorTotal());
	}
	
	public void test2() {
		this.carrinho.incluirProduto(new Produto("DVD-RW", 3.0d), 2);
		this.carrinho.incluirProduto(new Produto("BLUERAY", 25.5d), 5);
		this.carrinho.incluirProduto(new Produto("TV LCD", 4000d), 1);

		// o carrinho deve conter tres produtos
		assertEquals(3, this.carrinho.getItems().size());
	}
	
	
	public void testProdutosIguais() {
		this.carrinho.incluirProduto(new Produto("DVD-RW", 3.0d), 5);
		this.carrinho.incluirProduto(new Produto("DVD-RW", 3.0d), 10);
		this.carrinho.incluirProduto(new Produto("DVD-RW", 3.0d), 15);
		// o carrinho deve conter somente um produto
		assertEquals(1, this.carrinho.getItems().size());
		// o produto dever ter quantidade igual a 30
		assertEquals(30, this.carrinho.getItems().get(0).getQuantidade());
	}

}
