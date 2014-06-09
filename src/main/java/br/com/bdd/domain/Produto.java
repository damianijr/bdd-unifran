package br.com.bdd.domain;

import java.io.Serializable;


public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String nome;
	private double preco;
	private String imagem;

	public Produto(String nome, double preco) {
		this(nome, preco, null);
	}

	public Produto(String nome, double preco, String imagem) {
		this.nome = nome;
		this.preco = preco;
		this.imagem = imagem;
	}

	
	public String getImagem() {
		return imagem;
	}

	public String getNome() {
		return nome;
	}

	public double getPreco() {
		return preco;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
}
