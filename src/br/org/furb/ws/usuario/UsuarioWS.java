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
	public String buscar(String nome) {
		Usuario user = new Usuario();
		user.setId(99);
		user.setNome("Bah");
		return user.getNome();
	}
	
	@WebMethod
	public Usuario buscarUser(String nome) {
		Usuario user = new Usuario();
		user.setId(99);
		user.setNome("Bah");
		return user;
	}

}
