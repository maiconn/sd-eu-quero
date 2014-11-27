package br.org.furb.rmi.desejo;

import java.rmi.Naming;

import br.org.furb.util.Constantes;

public class DesejoClient {
	public static void main(String[] args) {
		try {
			DesejoRMI obj = (DesejoRMI) Naming.lookup("//" + Constantes.IP_RMI
					+ "/DesejoRMI");
			System.out.println("Mensagem do Servidor: " + obj.CriarDesejo());
		} catch (Exception ex) {
			System.out.println("Exception: " + ex.getMessage());
		}
	}

	public DesejoRMI getDesejoClient() throws Exception {
		DesejoRMI obj = (DesejoRMI) Naming.lookup("//" + Constantes.IP_RMI
				+ "/DesejoRMI");
		return obj;
	}
}
