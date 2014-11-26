package br.org.furb.rmi.desejo;

import java.rmi.*;
import java.rmi.server.*;

import br.org.furb.util.Constantes;

import com.sun.org.apache.bcel.internal.Constants;

public class DesejoServer extends UnicastRemoteObject implements DesejoRMI{

	protected DesejoServer() throws RemoteException {
		super();
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
	public String CriarDesejo() throws RemoteException {
		return "Desejo criado com sucesso";
	}
	

}
