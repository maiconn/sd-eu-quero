package br.org.furb.corba.anuncio;

import br.org.furb.controller.UsuarioController;
import br.org.furb.model.Sessao;
import br.org.furb.model.Usuario;
import br.org.furb.ws.usuario.cliente.Exception_Exception;
import _anuncio.AnuncioInterfacePOA;

public class AnuncioImpl extends AnuncioInterfacePOA {

	@Override
	public String getAnuncios(int idUsuario) {		

		Usuario usuario = null;
		
		try {
			
			// Busca gostos do usuário
			usuario = new UsuarioController().buscar(idUsuario);		
			
			AnuncioListas al = new AnuncioListas();
			
			// Busca por anuncios referentes aos gostos
			if (al.getListaDefault().containsKey(usuario.getGostos())){
				return al.getListaDefault().get(usuario.getGostos());				
			} 
			
			return al.getListaDefault().get("padrão");
			
		} catch (Exception_Exception e) {
			e.printStackTrace();
		}
		
		return "";
	}

}
