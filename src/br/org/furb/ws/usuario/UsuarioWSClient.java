package br.org.furb.ws.usuario;

import br.org.furb.ws.usuario.cliente.Exception_Exception;
import br.org.furb.ws.usuario.cliente.UsuarioWSService;

public class UsuarioWSClient {

	public static void main(String[] args) throws Exception_Exception {
		br.org.furb.ws.usuario.cliente.UsuarioWS port = new UsuarioWSService().getUsuarioWSPort();
		System.out.println(port.autenticar("reinoldo", "123"));
		System.out.println(port.buscar("reinoldo"));
		System.out.println(port.buscarUser("reinoldo").getNome());
	}
	
	public br.org.furb.ws.usuario.cliente.UsuarioWS getUsuarioClient(){
		return new UsuarioWSService().getUsuarioWSPort();
	}
	
}
