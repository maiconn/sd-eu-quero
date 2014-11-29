package br.org.furb.rmi.desejo;

import java.rmi.*;

import br.org.furb.model.Desejo;

public interface DesejoRMI extends Remote{

   public String CriarDesejo(Desejo desejo) throws RemoteException;

}
