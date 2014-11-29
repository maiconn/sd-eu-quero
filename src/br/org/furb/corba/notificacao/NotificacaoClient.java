package br.org.furb.corba.notificacao;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

import _notificacao.NotificacaoInterface;
import _notificacao.NotificacaoInterfaceHelper;
import br.org.furb.model.TipoNotificacao;
import br.org.furb.util.Constantes;

public class NotificacaoClient {
	
	private static final String[] ARGS = {"-ORBInitialHost", Constantes.IP_CORBA};
	private static final String SERVER_NAME = "NotificacaoInterface";


	public NotificacaoInterface getNotificacaoClient() throws Exception {
		// Cria e inicializa o ORB
		ORB orb = ORB.init(ARGS, null);

		// Obtem referencia para o servico de nomes
		org.omg.CORBA.Object objRef = orb
				.resolve_initial_references("NameService");
		NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

		// Obtem referencia para o servidor
		
		NotificacaoInterface server = NotificacaoInterfaceHelper.narrow(ncRef
				.resolve_str(SERVER_NAME));
		
		return server;
	}
	
	public static void main(String[] args) throws Exception {
		NotificacaoClient client = new NotificacaoClient();
		System.out.println(client.getNotificacaoClient().getNotificacoes(15));
		System.out.println(client.getNotificacaoClient().criarNotificacao(13, TipoNotificacao.DESEJO.ordinal(), 7));
	}

}
