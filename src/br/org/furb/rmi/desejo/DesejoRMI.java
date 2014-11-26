package br.org.furb.rmi.desejo;

import java.rmi.*;

public interface DesejoRMI extends Remote{

   public String CriarDesejo() throws RemoteException;

}
