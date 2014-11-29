package br.org.furb.rmi.oferta;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import br.org.furb.model.Oferta;

public interface OfertaRMI extends Remote {
   public void criarOferta(Oferta oferta) throws Exception;
   public List<Oferta> listar(Oferta ofertaInicial, Oferta ofertaFinal) throws Exception;
   public Oferta buscar(Oferta oferta) throws Exception;
}
