package br.org.furb.rmi.desejo;

import java.net.MalformedURLException;
import java.rmi.*;
import java.rmi.server.*;
import java.util.List;

import javax.swing.JOptionPane;

import br.org.furb.controller.DesejoController;
import br.org.furb.controller.OfertaController;
import br.org.furb.controller.UsuarioController;
import br.org.furb.controller.dao.DAO;
import br.org.furb.controller.dao.impl.DesejoDaoImpl;
import br.org.furb.controller.dao.impl.OfertaDaoImpl;
import br.org.furb.model.Desejo;
import br.org.furb.model.Oferta;
import br.org.furb.util.Constantes;

@SuppressWarnings("serial")
public class DesejoServer extends UnicastRemoteObject implements DesejoRMI{

	DAO<Desejo> desejoDaoImpl;
	
	protected DesejoServer() throws RemoteException, MalformedURLException, NotBoundException {
		super();
		desejoDaoImpl = new DesejoDaoImpl();
	}
	
	public static void main(String[] args) {
	   try {
	      DesejoServer obj = new DesejoServer();	      
	      System.out.println("Servidor RMI de DESEJOS startado...");
	      Naming.rebind("//" + Constantes.IP_RMI + "/DesejoRMI", obj);
	   } catch (Exception ex) {
	      System.out.println("Exception: " + ex.getMessage());
	   } 
	}	
	

	@Override
	public String CriarDesejo(Desejo desejo) throws RemoteException {
		try {
			if (desejo.getIdDesejo() == 0)
				desejo.setIdDesejo(desejoDaoImpl.incrementar());
			desejoDaoImpl.salvar(desejo);
		} catch (Exception e) {
			return e.getMessage();
		}
		return "Desejo criado com sucesso";
	}

	@Override
	public List<Desejo> listar(Desejo desejoInicial, Desejo desejoFinal) throws Exception {
		return desejoDaoImpl.listar(desejoInicial, desejoFinal);
	}

	@Override
	public String carregarDesejos() throws Exception {
		String result = "";
		List<Desejo> listaDesejos = new DesejoController().listar(null, null);
		UsuarioController usuarioController = new UsuarioController();
		OfertaController ofertaController = new OfertaController();
		Oferta ofertaInicial;
		for (Desejo desejo : listaDesejos) {
			result = result + "\n" + desejo + " - " + usuarioController.buscar(desejo.getIdUsuario()).getNome();
			ofertaInicial = new Oferta();
			ofertaInicial.setIdDesejo(desejo.getIdDesejo());
			List<Oferta> listaOfertas = ofertaController.listar(ofertaInicial, null);
			for (Oferta oferta : listaOfertas) {
				result = result + "\n                    " + oferta + " - " + usuarioController.buscar(oferta.getIdUsuario()).getNome();
			}
		}
		return result;
	}

	@Override
	public Desejo buscar(Desejo desejo) throws Exception {
		return desejoDaoImpl.buscar(desejo);
	}

	@Override
	public boolean excluir(Desejo desejo) throws Exception {
		Oferta ofertaInicial = new Oferta();
		OfertaController ofertaController = new OfertaController();
		ofertaInicial.setIdDesejo(desejo.getIdDesejo());
		List<Oferta> listaOfertas = ofertaController.listar(ofertaInicial, null);
		for (Oferta oferta : listaOfertas) {
			ofertaController.excluir(oferta);
		}
		return desejoDaoImpl.excluir(desejo);
	}

	@Override
	public boolean editar(Desejo desejo) throws Exception {
		return desejoDaoImpl.editar(desejo);
	}
	

}
