package br.org.furb.ws.usuario;

import br.org.furb.ws.usuario.cliente.UsuarioWSService;

public class TesteUsuarioWS {

	public static void main(String[] args) {
		br.org.furb.ws.usuario.cliente.UsuarioWS port = new UsuarioWSService().getUsuarioWSPort();
		System.out.println(port.autenticar("reinoldo", "123"));
		System.out.println(port.buscar("reinoldo"));
		System.out.println(port.buscarUser("reinoldo").getNome());
	}
	
}
