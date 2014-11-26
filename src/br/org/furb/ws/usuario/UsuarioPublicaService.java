package br.org.furb.ws.usuario;

import javax.xml.ws.Endpoint;

import br.org.furb.util.Constantes;

public class UsuarioPublicaService {
	public static void main(String[] args) {
		UsuarioWS service = new UsuarioWS();
		Endpoint endpoint = Endpoint.publish("http://" + Constantes.IP_WS
				+ "/usuario", service);
	}
}
