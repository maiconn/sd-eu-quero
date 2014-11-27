package br.org.furb.corba.anuncio;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

import _anuncio.AnuncioInterface;
import _anuncio.AnuncioInterfaceHelper;
import br.org.furb.util.Constantes;

public class AnuncioClient {
	
	private static final String[] ARGS = {"-ORBInitialHost", Constantes.IP_CORBA};
	private static final String SERVER_NAME = "AnuncioInterface";


	public AnuncioInterface getAnuncioClient() throws Exception {
		// Cria e inicializa o ORB
		ORB orb = ORB.init(ARGS, null);

		// Obtem referencia para o servico de nomes
		org.omg.CORBA.Object objRef = orb
				.resolve_initial_references("NameService");
		NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

		// Obtem referencia para o servidor
		
		AnuncioInterface server = AnuncioInterfaceHelper.narrow(ncRef
				.resolve_str(SERVER_NAME));
		
		return server;
	}
	
	public static void main(String[] args) throws Exception {
		AnuncioClient client = new AnuncioClient();
		System.out.println(client.getAnuncioClient().getAnuncios(10));
	}

}
