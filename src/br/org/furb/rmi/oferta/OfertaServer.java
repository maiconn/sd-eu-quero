package br.org.furb.rmi.oferta;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import br.org.furb.model.Oferta;
import br.org.furb.util.Constantes;

public class OfertaServer extends UnicastRemoteObject implements OfertaRMI {
	private static final long serialVersionUID = 1L;

	public OfertaServer() throws RemoteException {
		super();
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
	public void criarOferta(Oferta oferta) throws RemoteException {
		System.out.println("oferta criada com sucesso!!!!!! _id:"
				+ oferta.getId());
	}

}
