package br.org.furb.controller;

import br.org.furb.model.Usuario;
import br.org.furb.ws.usuario.UsuarioWSClient;
import br.org.furb.ws.usuario.cliente.Exception_Exception;

public class UsuarioController {
	
	private Usuario getUsuario(br.org.furb.ws.usuario.cliente.Usuario usuarioWS){
		
		if(usuarioWS == null){
			return null;
		}
		
		Usuario usuario = new Usuario();
		usuario.setCep(usuarioWS.getCep());
		usuario.setEmail(usuarioWS.getEmail());
		usuario.setId(usuarioWS.getId());
		usuario.setNome(usuarioWS.getNome());
		usuario.setSenha(usuarioWS.getSenha());
		usuario.setTelefone(usuarioWS.getTelefone());
		usuario.setGostos(usuarioWS.getGostos());
		
		return usuario;
	}
	
	public boolean cadastrarUsuario(Usuario usuario) throws Exception{
		UsuarioWSClient usuarioClient = new UsuarioWSClient();
		
		br.org.furb.ws.usuario.cliente.Usuario usuarioWS = new br.org.furb.ws.usuario.cliente.Usuario();
		usuarioWS.setCep(usuario.getCep());
		usuarioWS.setEmail(usuario.getEmail());
		usuarioWS.setId(usuario.getId());
		usuarioWS.setNome(usuario.getNome());
		usuarioWS.setSenha(usuario.getSenha());
		usuarioWS.setTelefone(usuario.getTelefone());
		
		return usuarioClient.getUsuarioClient().criarUsuario(usuarioWS);
	}
	
	public Usuario autenticar(String email, String senha) throws Exception{
		UsuarioWSClient usuarioClient = new UsuarioWSClient();
		
		br.org.furb.ws.usuario.cliente.Usuario usuarioWS = usuarioClient.getUsuarioClient().autenticar(email, senha);
		
		return getUsuario(usuarioWS);
	}
	
	public Usuario buscar(int id) throws Exception_Exception{
		UsuarioWSClient usuarioClient = new UsuarioWSClient();
		
		br.org.furb.ws.usuario.cliente.Usuario usuarioWS = usuarioClient.getUsuarioClient().buscar(id);		
		
		return getUsuario(usuarioWS);
		
	}
}
