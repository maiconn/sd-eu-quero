package br.org.furb.corba.anuncio;

import _anuncio.AnuncioInterfacePOA;

public class AnuncioImpl extends AnuncioInterfacePOA {

	@Override
	public String getAnuncios(int idUsuario) {

		return "Aqui irá retornar os anúnicos com o usuario: " + idUsuario;
	}

}
