package br.org.furb.rmi.oferta;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import br.org.furb.controller.dao.DAO;
import br.org.furb.controller.dao.impl.OfertaDaoImpl;
import br.org.furb.model.Oferta;
import br.org.furb.util.Constantes;

public class OfertaServer extends UnicastRemoteObject implements OfertaRMI {
	private static final long serialVersionUID = 1L;

	DAO<Oferta> ofertaDaoImpl;
	
	public OfertaServer() throws RemoteException {
		super();
		ofertaDaoImpl = new OfertaDaoImpl(); 
	}

	// main()
	public static void main(String[] args) {
		try {
			OfertaServer obj = new OfertaServer();
			Naming.rebind("//" + Constantes.IP_RMI + "/Oferta", obj);
		} catch (Exception ex) {
			System.out.println("Exception: " + ex.getMessage());
		}
	}

	@Override
	public void criarOferta(Oferta oferta) throws Exception {
		if (oferta.getId() == 0)
			oferta.setId(ofertaDaoImpl.incrementar());
		ofertaDaoImpl.salvar(oferta);
		System.out.println("oferta criada com sucesso!!!!!! _id:" + oferta.getId());
	}

	@Override
	public List<Oferta> listar(Oferta ofertaInicial, Oferta ofertaFinal) throws Exception {
		return ofertaDaoImpl.listar(ofertaInicial, ofertaFinal);
	}

}
