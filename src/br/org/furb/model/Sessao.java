package br.org.furb.model;

public class Sessao {
	private static Sessao sessao;
	private Usuario usuario;

	public static Sessao getInstance() {
		if (sessao == null) {
			sessao = new Sessao();
		}
		return sessao;
	}

	private Sessao() {

	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
