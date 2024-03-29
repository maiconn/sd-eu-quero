package br.org.furb.rmi.oferta;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import br.org.furb.controller.NotificacaoController;
import br.org.furb.controller.dao.DAO;
import br.org.furb.controller.dao.impl.OfertaDaoImpl;
import br.org.furb.model.Oferta;
import br.org.furb.model.TipoNotificacao;
import br.org.furb.util.Constantes;

public class OfertaServer extends UnicastRemoteObject implements OfertaRMI {
	private static final long serialVersionUID = 1L;

	DAO<Oferta> ofertaDaoImpl;
	NotificacaoController notificacaoController;
	
	public OfertaServer() throws RemoteException {
		super();
		ofertaDaoImpl = new OfertaDaoImpl(); 
		notificacaoController = new NotificacaoController();
	}

	// main()
	public static void main(String[] args) {
		try {
			OfertaServer obj = new OfertaServer();
			System.out.println("Servidor RMI de OFERTAS startado...");
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
		notificacaoController.criarNotificacao(oferta.getId(), TipoNotificacao.OFERTA.ordinal(), oferta.getId());
	}

	@Override
	public List<Oferta> listar(Oferta ofertaInicial, Oferta ofertaFinal) throws Exception {
		return ofertaDaoImpl.listar(ofertaInicial, ofertaFinal);
	}

	@Override
	public Oferta buscar(Oferta oferta) throws Exception {
		return ofertaDaoImpl.buscar(oferta);
	}

	@Override
	public boolean excluir(Oferta oferta) throws Exception {
		return ofertaDaoImpl.excluir(oferta);
	}

	@Override
	public boolean editar(Oferta oferta) throws Exception {
		return ofertaDaoImpl.editar(oferta);
	}

}
