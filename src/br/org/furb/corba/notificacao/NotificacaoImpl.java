package br.org.furb.corba.notificacao;

import br.org.furb.model.TipoNotificacao;
import _notificacao.NotificacaoInterfacePOA;

public class NotificacaoImpl extends NotificacaoInterfacePOA{

	@Override
	public String getNotificoes(int idUsuario) {
		
		return "este método retornará as notificações para o usuário: "+idUsuario;
	}

	@Override
	public boolean criarNotificacao(int idUsuario, int tipoNotificacao) {
		TipoNotificacao tipo = TipoNotificacao.values()[tipoNotificacao];
		
		System.out.println(tipo.toString());
		return true;
	}

}
