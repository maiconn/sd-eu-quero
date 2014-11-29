package br.org.furb.model;

import java.util.Date;

import br.org.furb.controller.dao.util.MongoDBObject;

@SuppressWarnings("serial")
public class Oferta extends MongoDBObject {
	private int id;
	private String descricao;
	private String caminhoImagem;
	private double valorOferta;
	private Date dataCriacao;
	private Date dataTermino;
	private String local;
	private int qtdMinimaParticipantes;
	private StatusOferta status;
	private int idUsuario;
	private int idDesejo;

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getIdDesejo() {
		return idDesejo;
	}

	public void setIdDesejo(int idDesejo) {
		this.idDesejo = idDesejo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCaminhoImagem() {
		return caminhoImagem;
	}

	public void setCaminhoImagem(String caminhoImagem) {
		this.caminhoImagem = caminhoImagem;
	}

	public double getValorOferta() {
		return valorOferta;
	}

	public void setValorOferta(double valorOferta) {
		this.valorOferta = valorOferta;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Date getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(Date dataTermino) {
		this.dataTermino = dataTermino;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public int getQtdMinimaParticipantes() {
		return qtdMinimaParticipantes;
	}

	public void setQtdMinimaParticipantes(int qtdMinimaParticipantes) {
		this.qtdMinimaParticipantes = qtdMinimaParticipantes;
	}

	public StatusOferta getStatus() {
		return status;
	}

	public void setStatus(StatusOferta status) {
		this.status = status;
	}
	
	public String toString() {
		return id + " - " + descricao + " - " + valorOferta;
	}
}
