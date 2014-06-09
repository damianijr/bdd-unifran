package br.com.bdd.behave;

public class CarrinhoStory extends JBehaveStory {

	@Override
	public String storyFile() {
		return "carrinho.story";
	}

	@Override
	public Object steps() {
		return new CarrinhoSteps();
	}

}
