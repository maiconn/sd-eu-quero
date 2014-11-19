package br.org.furb.ws.usuario;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class UsuarioWS {

	@WebMethod
	public String autenticar(String usuario, String senha) {		
		return "autenticado ";		
	}

	@WebMethod
	public int soma(int x, int y) {
		return x + y;
	}

}
