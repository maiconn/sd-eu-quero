package br.org.furb.ws.usuario;

import javax.jws.WebMethod;
import javax.jws.WebService;

import br.org.furb.model.Usuario;

@WebService
public class UsuarioWS {

	@WebMethod
	public String autenticar(String email, String senha) {		
		return "autenticado ";		
	}

	@WebMethod
	public Usuario buscar(String nome) {
		Usuario user = new Usuario();
		user.setNome("Tester1");
		user.setId(99);
		return user;
	}

}
