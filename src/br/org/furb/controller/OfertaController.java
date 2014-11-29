package br.org.furb.controller;

import java.util.List;

import br.org.furb.model.Oferta;
import br.org.furb.rmi.oferta.OfertaClient;

public class OfertaController {
	public void criarOferta(Oferta oferta) throws Exception {
		new OfertaClient().getOfertaClient().criarOferta(oferta);
	}
	
	public List<Oferta> listar(Oferta ofertaInicial, Oferta ofertaFinal) throws Exception {
		return new OfertaClient().getOfertaClient().listar(ofertaInicial, ofertaFinal);
	}
	
	public Oferta buscar(Oferta oferta) throws Exception {
		return new OfertaClient().getOfertaClient().buscar(oferta);
	}
	
	public boolean excluir(Oferta oferta) throws Exception {
		return new OfertaClient().getOfertaClient().excluir(oferta);
	}
	
	public boolean editar(Oferta oferta) throws Exception {
		return new OfertaClient().getOfertaClient().editar(oferta);
	}
}
