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
			if (usuario != null && usuario.getGostos()!=null && !usuario.getGostos().isEmpty()){
				String[] gostos = usuario.getGostos().split(";");
				String anuncios = "";
				
				// Concatenas vários gostos
				for (int i = 0; i < gostos.length; i++) {
					
					if (al.getListaDefault().containsKey(gostos[i])){
						anuncios = anuncios + al.getListaDefault().get(gostos[i]) + ";";				
					}
					
				}
				
				// Se não encontrar nenhum gosto retorna o padrão
				if (anuncios.isEmpty()) 
					return al.getListaDefault().get("padrão");
				else
					return anuncios;
				
			}else{
				return al.getListaDefault().get("padrão");
			}
			
		} catch (Exception_Exception e) {
			e.printStackTrace();
		}
		
		
		return "";
	}

}
