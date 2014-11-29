package br.org.furb.model;

import br.org.furb.controller.dao.util.MongoDBObject;

@SuppressWarnings("serial")
public class Notificacao extends MongoDBObject {
	private int id;
	private int idUsuario;	
	private TipoNotificacao tipoNotificacao;
	private String descricao;
	private StatusNotificacao status;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	public TipoNotificacao getTipoNotificacao() {
		return tipoNotificacao;
	}
	public void setTipoNotificacao(TipoNotificacao tipoNotificacao) {
		this.tipoNotificacao = tipoNotificacao;
	}

	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public StatusNotificacao getStatus() {
		return status;
	}
	public void setStatus(StatusNotificacao status) {
		this.status = status;
	}
}
