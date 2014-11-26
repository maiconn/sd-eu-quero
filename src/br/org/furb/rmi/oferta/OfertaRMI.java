package br.org.furb.rmi.oferta;

import java.rmi.Remote;
import java.rmi.RemoteException;

import br.org.furb.model.Oferta;

public interface OfertaRMI extends Remote {
   public void criarOferta(Oferta oferta) throws RemoteException;
}
