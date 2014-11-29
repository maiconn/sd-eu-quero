package br.org.furb.corba.anuncio;

import java.util.HashMap;
import java.util.Map;

public class AnuncioListas {

	private Map<String, String> listaDefault;

	public Map<String, String> getLista() {
		setListaDefault();
		return listaDefault;
	}

	private void setListaDefault() {
		listaDefault = new HashMap<String, String>();
		listaDefault.put("padrão", "Compartilhe o eu quero com seus amigos :)");
		listaDefault.put("mulher", "Faça uma conta no tinder e conheça novas mulheres");
		listaDefault.put("homem", "Faça uma conta no tinder e conheça novas homens");
		listaDefault.put("futebol", "NetShoes melhores ofertas para um boleiro");
		listaDefault.put("filme", "Assine Sky");
		listaDefault.put("eletrônicos", "Notebook Asus R$1300,00");
		listaDefault.put("carros", "Conheça o novo UP (www.volkswagen.com.br)");		
	}
	
	
}
