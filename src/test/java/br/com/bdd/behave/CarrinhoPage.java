package br.com.bdd.behave;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CarrinhoPage {

	private WebDriver webDriver;

	public CarrinhoPage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}

	public void abrir_pagina() {
		this.webDriver.navigate().to("http://localhost:8080/bdd/index.jsf");
	}

	public boolean verificaProdutoVisivel(String produto) {
		try {
			return this.webDriver.findElement(By.xpath("//tr/td/span[contains(@id, 'produto_nome')]")).getText().equals(produto);
		}
		catch (Exception ex) {
			return false;
		}
	}

	public void proximo_produto() {
		this.webDriver.findElement(By.cssSelector(".ui-carousel-next-button")).click();
	}

	public void quantidade(String quantidade) {
		WebElement findElement = this.webDriver.findElement(By.xpath("//tr/td/*[contains(@id, 'produto_quantidade')]/input"));
		findElement.clear();
		findElement.sendKeys(quantidade);
	}

	public void adicionar() {
		this.webDriver.findElement(By.xpath("//tr/td/*[contains(@id, 'produto_adicionar')]")).click();
		
	}
}
