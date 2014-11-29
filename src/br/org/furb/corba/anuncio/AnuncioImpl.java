package br.org.furb.corba.anuncio;

import java.util.Map;

import _anuncio.AnuncioInterfacePOA;
import br.org.furb.controller.UsuarioController;
import br.org.furb.model.Usuario;
import br.org.furb.ws.usuario.cliente.Exception_Exception;

public class AnuncioImpl extends AnuncioInterfacePOA {

	@Override
	public String getAnuncios(int idUsuario) {		

		Usuario usuario = null;		
		
		try {
			
			// Busca gostos do usuário
			usuario = new UsuarioController().buscar(idUsuario);								
			AnuncioListas anuncioListas = new AnuncioListas();			
			
			// Busca por anuncios referentes aos gostos
			if (usuario != null && usuario.getGostos()!=null && !usuario.getGostos().isEmpty()){
				String[] gostos = usuario.getGostos().split(";");
				String anuncios = "";
				
				// Concatenas vários gostos
				Map<String, String> anunciosList = anuncioListas.getLista();
				for (int i = 0; i < gostos.length; i++) {
					
					String gosto = anunciosList.get(gostos[i].trim());
					if(gosto != null){
						anuncios += gosto+";";
					}
					
				}
				
				// Se não encontrar nenhum gosto retorna o padrão
				if (anuncios.isEmpty()) 
					return anuncioListas.getLista().get("padrão");
				else
					return anuncios;
				
			}else{
				return anuncioListas.getLista().get("padrão");
			}
			
		} catch (Exception_Exception e) {
			e.printStackTrace();
		}
		
		
		return "";
	}

}
