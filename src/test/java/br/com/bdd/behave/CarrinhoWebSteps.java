package br.com.bdd.behave;


import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Pending;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.WebDriver;

public class CarrinhoWebSteps {
	
	private CarrinhoPage carrinhoPage;

	public CarrinhoWebSteps(WebDriver driver) {
		this.carrinhoPage = new CarrinhoPage(driver);
	}


	@Given("o cliente acesse a pagina do carrinho de compras")
	public void givenOClienteAcesseAPaginaDoCarrinhoDeCompras() {
		this.carrinhoPage.abrir_pagina();
	}

	@When("o cliente adiciona '$quantidade' unidades do produto '$protudo' ao carrinho")
	public void whenOClienteAdiciona30UnidadesDoProdutoChromeCastAoCarrinho(String quantidade, String produto) {
		seleciona_produto(produto);
		this.carrinhoPage.quantidade(quantidade);
		this.carrinhoPage.adicionar();
	}

	private void seleciona_produto(String produto) {
		while (!this.carrinhoPage.verificaProdutoVisivel(produto)) {
			this.carrinhoPage.proximo_produto();
		}
	}
}
