package br.org.furb.ws.usuario;

import javax.xml.ws.Endpoint;


public class UsuarioPublicaService {
	public static void main(String[] args){
		UsuarioWS service = new UsuarioWS();
		Endpoint endpoint = Endpoint.publish("http://localhost/usuario", service);
	}
}
