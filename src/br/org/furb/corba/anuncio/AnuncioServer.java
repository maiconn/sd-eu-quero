package br.org.furb.corba.anuncio;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

import _anuncio.AnuncioInterface;
import _anuncio.AnuncioInterfaceHelper;

public class AnuncioServer {
	
	private static final String SERVER_NAME = "AnuncioInterface";

	public static void main(String args[]) {
		try {
			// Cria e inicializa o ORB
			ORB orb = ORB.init(args, null);

			// Cria a implementação e registra no ORB
			AnuncioImpl impl = new AnuncioImpl();

			// Ativa o POA
			POA rootpoa = POAHelper.narrow(orb
					.resolve_initial_references("RootPOA"));
			rootpoa.the_POAManager().activate();

			// Pega a referência do servidor
			org.omg.CORBA.Object ref = rootpoa.servant_to_reference(impl);
			AnuncioInterface href = AnuncioInterfaceHelper.narrow(ref);

			// Obtém uma referência para o servidor de nomes
			org.omg.CORBA.Object objRef = orb
					.resolve_initial_references("NameService");
			NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

			// Registra o servidor no servico de nomes
			NameComponent path[] = ncRef.to_name(SERVER_NAME);
			ncRef.rebind(path, href);

			System.out.println("Servidor de anúncios aguardando requisicoes....");

			// Aguarda chamadas dos clientes
			orb.run();
		} catch (Exception e) {
			System.err.println("ERRO: " + e);
			e.printStackTrace(System.out);
		}
		System.out.println("Encerrando o Servidor.");
	}
}
