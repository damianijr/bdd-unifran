package br.com.bdd.tdd;

import org.junit.Assert;
import org.junit.Test;

import br.com.bdd.domain.Carrinho;
import br.com.bdd.domain.Produto;

public class TestCarrinho2 {

	private Carrinho carrinho = new Carrinho();
	
	@Test
	public void adicionar_varios_produtos() {
		this.carrinho.incluirProduto(new Produto("DVD-RW", 3.0d), 2);
		this.carrinho.incluirProduto(new Produto("BLUERAY", 25.5d), 5);
		this.carrinho.incluirProduto(new Produto("TV LCD", 4000d), 1);

		// o carrinho deve conter tres produtos
		Assert.assertEquals(3, this.carrinho.getItems().size());
	}
	
	@Test
	public void calcular_o_valor_total_dos_produtos_que_estao_no_carrinho() {
		this.carrinho.incluirProduto(new Produto("DVD-RW", 3.0d), 2);
		this.carrinho.incluirProduto(new Produto("BLUERAY", 25.5d), 2);
		// Valor esperado é 3*2 + 25.5*2 = 57
		Assert.assertEquals(57d, this.carrinho.valorTotal(), 0);
	}

	@Test
	public void agrupar_produtos_iguais() {
		this.carrinho.incluirProduto(new Produto("DVD-RW", 3.0d), 5);
		this.carrinho.incluirProduto(new Produto("DVD-RW", 3.0d), 10);
		this.carrinho.incluirProduto(new Produto("DVD-RW", 3.0d), 15);
		// o carrinho deve conter somente um produto
		Assert.assertEquals(1, this.carrinho.getItems().size());	
	}
	
	public void somar_as_quantidades_dos_produtos_agrupados() {
		this.carrinho.incluirProduto(new Produto("DVD-RW", 3.0d), 5);
		this.carrinho.incluirProduto(new Produto("DVD-RW", 3.0d), 10);
		this.carrinho.incluirProduto(new Produto("DVD-RW", 3.0d), 15);
		// o produto dever ter quantidade igual a 30
		Assert.assertEquals(30, this.carrinho.getItems().get(0).getQuantidade());
	}

}
