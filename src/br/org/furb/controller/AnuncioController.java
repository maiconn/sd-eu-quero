package br.org.furb.controller;

import br.org.furb.corba.anuncio.AnuncioClient;

public class AnuncioController {

	public String getAnuncios(int idUsuario) throws Exception{
		AnuncioClient client = new AnuncioClient();		
		return client.getAnuncioClient().getAnuncios(idUsuario);
	}
	
}
