package br.com.bdd.behave;


public class CarrinhoWebStory extends JBehaveWebStory {

	@Override
	public String storyFile() {
		return "carrinho_web.story";
	}

	@Override
	public Object steps() {
		return new CarrinhoWebSteps(this.getWebDriverProvider());
	}

}
