package br.org.furb.controller;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import br.org.furb.model.Desejo;
import br.org.furb.rmi.desejo.DesejoRMI;
import br.org.furb.util.Constantes;

public class DesejoController {
	
	DesejoRMI desejoRMI;
	
	public DesejoController() throws MalformedURLException, RemoteException, NotBoundException {
		desejoRMI = (DesejoRMI) Naming.lookup("//" + Constantes.IP_RMI + "/DesejoRMI");
	}
	
	public void criarDesejo(Desejo desejo) throws Exception {
		desejoRMI.CriarDesejo(desejo);
	}
}
