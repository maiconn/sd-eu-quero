package br.org.furb.rmi.desejo;

import java.rmi.*;
import java.util.List;

import br.org.furb.model.Desejo;

public interface DesejoRMI extends Remote{

   public String CriarDesejo(Desejo desejo) throws RemoteException;
   public List<Desejo> listar(Desejo desejoInicial, Desejo desejoFinal) throws Exception;
   public String carregarDesejos() throws Exception;
}
