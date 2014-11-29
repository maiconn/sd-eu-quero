package br.org.furb.controller;

import br.org.furb.corba.notificacao.NotificacaoClient;

public class NotificacaoController {

	public String getNotificacoes(int idUsuario) throws Exception {
		NotificacaoClient notificacaoClient = new NotificacaoClient();		
		
		return notificacaoClient.getNotificacaoClient().getNotificacoes(idUsuario);
	}
		
	public boolean criarNotificacao(int idUsuario, int tipoNotificacao, int idDesejoOferta) throws Exception {
		NotificacaoClient notificacaoClient = new NotificacaoClient();		
		
		return notificacaoClient.getNotificacaoClient().criarNotificacao(idUsuario, tipoNotificacao, idDesejoOferta);
	}
	
}
