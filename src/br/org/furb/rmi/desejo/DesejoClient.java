package br.org.furb.rmi.desejo;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Date;

import br.org.furb.model.Desejo;
import br.org.furb.model.StatusDesejo;
import br.org.furb.util.Constantes;

public class DesejoClient {
	public static void main(String[] args) {
		try {
			DesejoRMI obj = (DesejoRMI) Naming.lookup("//" + Constantes.IP_RMI
					+ "/DesejoRMI");
			Desejo desejo = new Desejo();
			desejo.setIdDesejo(0);
			desejo.setCaminhoImagem("C:\temp\teste.png");
			desejo.setCategoria("Teste");
			desejo.setDataCriacao(new Date("10/02/2014"));
			desejo.setDataTermino(new Date("25/02/2014"));
			desejo.setDescricao("Paranauê Paraná");
			desejo.setStatus(StatusDesejo.ABERTO);
			desejo.setTitulo("Sou Metrô, não tem título");
			System.out.println("Mensagem do Servidor: " + obj.CriarDesejo(desejo));
		} catch (Exception ex) {
			System.out.println("Exception: " + ex.getMessage());
		}
	}

	public DesejoRMI getDesejoClient() throws Exception {
		DesejoRMI obj = (DesejoRMI) Naming.lookup("//" + Constantes.IP_RMI
				+ "/DesejoRMI");
		return obj;
	}
	
	public String CriarDesejo(Desejo desejo) throws RemoteException, MalformedURLException, NotBoundException{
		DesejoRMI obj = (DesejoRMI) Naming.lookup("//" + Constantes.IP_RMI + "/DesejoRMI");
		return (obj.CriarDesejo(desejo));
	}
}
