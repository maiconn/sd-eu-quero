package br.org.furb.rmi.desejo.model;

import java.util.Date;

public class Desejo {
	private int idDesejo;
	private String titulo;
	private String descrição;
	private String caminhoImagem;
	private Date dataCriacao;
	private Date dataTermino;
	private StatusDesejo status;
	private String categoria;
	
	public int getIdDesejo() {
		return idDesejo;
	}
	public void setIdDesejo(int idDesejo) {
		this.idDesejo = idDesejo;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescrição() {
		return descrição;
	}
	public void setDescrição(String descrição) {
		this.descrição = descrição;
	}
	public String getCaminhoImagem() {
		return caminhoImagem;
	}
	public void setCaminhoImagem(String caminhoImagem) {
		this.caminhoImagem = caminhoImagem;
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
	public StatusDesejo getStatus() {
		return status;
	}
	public void setStatus(StatusDesejo status) {
		this.status = status;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
}
