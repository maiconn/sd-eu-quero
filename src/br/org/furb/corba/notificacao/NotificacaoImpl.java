package br.org.furb.corba.notificacao;

import java.util.ArrayList;
import java.util.List;

import _notificacao.NotificacaoInterfacePOA;
import br.org.furb.controller.dao.impl.NotificacaoDaoImpl;
import br.org.furb.model.Notificacao;
import br.org.furb.model.TipoNotificacao;

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
		
		Notificacao notificacao = new Notificacao();
		
		try {
			
			notificacao.setId(dao.incrementar());
			notificacao.setIdUsuario(idUsuario);
			notificacao.setTipoNotificacao(tipo);
			
			if (tipo == TipoNotificacao.DESEJO){
				descricao = "O desejo " + idDesejoOferta + " foi criado com sucesso";
			}else if (tipo == TipoNotificacao.OFERTA){
				descricao = "A oferta " + idDesejoOferta + " foi criada com sucesso";
			}else{
				descricao = "Notificação não identificada " + tipoNotificacao;
			}	
			
			notificacao.setDescricao(descricao);		
			//notificacao.setStatus("");		
		
			dao.salvar(notificacao);
			
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
		return true;
	}

}
