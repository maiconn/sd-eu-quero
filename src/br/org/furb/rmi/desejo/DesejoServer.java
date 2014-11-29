package br.org.furb.rmi.desejo;

import java.net.MalformedURLException;
import java.rmi.*;
import java.rmi.server.*;

import br.org.furb.controller.dao.DAO;
import br.org.furb.controller.dao.impl.DesejoDaoImpl;
import br.org.furb.model.Desejo;
import br.org.furb.util.Constantes;

@SuppressWarnings("serial")
public class DesejoServer extends UnicastRemoteObject implements DesejoRMI{

	DAO<Desejo> desejoDaoImpl;
	
	protected DesejoServer() throws RemoteException, MalformedURLException, NotBoundException {
		super();
		desejoDaoImpl = new DesejoDaoImpl();
	}
	
	public static void main(String[] args) {
	   try {
	      DesejoServer obj = new DesejoServer();	      
	      Naming.rebind("//" + Constantes.IP_RMI + "/DesejoRMI", obj);
	   } catch (Exception ex) {
	      System.out.println("Exception: " + ex.getMessage());
	   } 
	}	
	

	@Override
	public String CriarDesejo(Desejo desejo) throws RemoteException {
		try {
			if (desejo.getIdDesejo() == 0)
				desejo.setIdDesejo(desejoDaoImpl.incrementar());
			desejoDaoImpl.salvar(desejo);
		} catch (Exception e) {
			return e.getMessage();
		}
		return "Desejo criado com sucesso";
	}
	

}
