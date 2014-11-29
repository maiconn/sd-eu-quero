package br.org.furb.controller;

import java.util.List;

import br.org.furb.model.Desejo;
import br.org.furb.rmi.desejo.DesejoClient;

public class DesejoController {
	
	public void criarDesejo(Desejo desejo) throws Exception {
		new DesejoClient().getDesejoClient().CriarDesejo(desejo);
	}
	
	public List<Desejo> listar(Desejo desejoInicial, Desejo desejoFinal) throws Exception {
		return new DesejoClient().getDesejoClient().listar(desejoInicial, desejoFinal);
	}
	
	public String carregarDesejos() throws Exception {
		return new DesejoClient().getDesejoClient().carregarDesejos();
	}
	
	public Desejo buscar(Desejo desejo) throws Exception {
		return new DesejoClient().getDesejoClient().buscar(desejo);
	}

	public boolean excluir(Desejo desejo) throws Exception {
		return new DesejoClient().getDesejoClient().excluir(desejo);
	}
	
	public boolean editar(Desejo desejo) throws Exception {
		return new DesejoClient().getDesejoClient().editar(desejo);
	}
}
