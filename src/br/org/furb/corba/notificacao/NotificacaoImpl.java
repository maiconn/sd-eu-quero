package br.org.furb.corba.notificacao;

import java.util.ArrayList;
import java.util.List;

import _notificacao.NotificacaoInterfacePOA;
import br.org.furb.controller.DesejoController;
import br.org.furb.controller.OfertaController;
import br.org.furb.controller.UsuarioController;
import br.org.furb.controller.dao.impl.NotificacaoDaoImpl;
import br.org.furb.model.Desejo;
import br.org.furb.model.Notificacao;
import br.org.furb.model.Oferta;
import br.org.furb.model.TipoNotificacao;
import br.org.furb.model.Usuario;

public class NotificacaoImpl extends NotificacaoInterfacePOA{

	@Override
	public String getNotificacoes(int idUsuario) {
		NotificacaoDaoImpl dao = new NotificacaoDaoImpl();
		
		Notificacao notificacao = new Notificacao();
		
		String notificacoes = "";
		
		notificacao.setIdUsuario(idUsuario);
		List<Notificacao> listNotificacoes = new ArrayList<Notificacao>();
		
		try {
			listNotificacoes = dao.listar(notificacao, null);
		} catch (Exception e) {		
			e.printStackTrace();
		}	
		
		for (int i = 0; i < listNotificacoes.size(); i++) {
			notificacao = listNotificacoes.get(i);
			notificacoes += notificacao.getDescricao() + ";";
		}		
		
		return notificacoes;
	}

	@Override
	public boolean criarNotificacao(int idUsuario, int tipoNotificacao, int idDesejoOferta) {
		NotificacaoDaoImpl dao = new NotificacaoDaoImpl();
		TipoNotificacao tipo = TipoNotificacao.values()[tipoNotificacao];
		String descricao = "";
		
		System.out.println(tipo.toString());		
		
		try {			
						
			if (tipo == TipoNotificacao.DESEJO){
				
				DesejoController desejoController = new DesejoController();
				Desejo desejo = new Desejo();
				desejo.setIdDesejo(idDesejoOferta);
				desejo = desejoController.buscar(desejo);
				if (desejo!=null){					
					descricao = "Seu desejo '" + desejo.getDescricao()+ "' foi criado com sucesso. Compartilhe com seus amigos.";
				}	
				
			}else if (tipo == TipoNotificacao.OFERTA){
				OfertaController ofertaController = new OfertaController();				
				Oferta oferta = new Oferta();				
				oferta.setId(idDesejoOferta);
				oferta = ofertaController.buscar(oferta);
				
				if (oferta!=null){
					DesejoController desejoController = new DesejoController();
					Desejo desejo = new Desejo();
					desejo.setIdDesejo(oferta.getIdDesejo());
					desejo = desejoController.buscar(desejo);
					
					if (desejo != null){
						idUsuario = desejo.getIdUsuario();
						UsuarioController usuarioController = new UsuarioController();
						Usuario usuario = usuarioController.buscar(oferta.getIdUsuario());
						
						descricao = "Seu desejo " + desejo.getDescricao() + " foi ofertado por " + usuario.getNome();
					}
				}
			}else{
				descricao = "Notificação não identificada " + tipoNotificacao;
			}	
			
			if (!descricao.isEmpty()) {
				
				Notificacao notificacao = new Notificacao();
				notificacao.setId(dao.incrementar());
				notificacao.setIdUsuario(idUsuario);
				notificacao.setTipoNotificacao(tipo);
				notificacao.setDescricao(descricao);		
				//notificacao.setStatus("");		
			
				dao.salvar(notificacao);
				
			}						
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
		return true;
	}

}
