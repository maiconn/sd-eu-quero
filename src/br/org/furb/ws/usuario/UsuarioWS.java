package br.org.furb.ws.usuario;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import br.org.furb.controller.dao.impl.UsuarioDaoImpl;
import br.org.furb.model.Usuario;

@WebService
public class UsuarioWS {

	@WebMethod
	public Usuario autenticar(String email, String senha) throws Exception {		
		UsuarioDaoImpl dao = new UsuarioDaoImpl();
		Usuario usuario = new Usuario();
		usuario.setEmail(email);
		usuario.setSenha(senha);
		List<Usuario> find = dao.listar(usuario, null);
		if(find.isEmpty()){
			return null;
		}
		return find.get(0);		
	}

	@WebMethod
	public Usuario buscar(int id) throws Exception {
		UsuarioDaoImpl dao = new UsuarioDaoImpl();
		Usuario usuario = new Usuario();
		usuario.setId(id);
		List<Usuario> find = dao.listar(usuario, null);
		if(find.isEmpty()){
			return null;
		}
		return find.get(0);
	}
	
	@WebMethod
	public Usuario buscarUser(String nome) {
		Usuario user = new Usuario();
		user.setId(99);
		user.setNome("Bah");
		return user;
	}
	
	@WebMethod
	public boolean criarUsuario(Usuario usuario) throws Exception{
		UsuarioDaoImpl dao = new UsuarioDaoImpl();
		return dao.salvar(usuario);
	}	

}
