package br.org.furb.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class Usuario {

	@WebMethod
	public String hello(String nome) {
		return "ola do servidor " + nome;
	}

	@WebMethod
	public int soma(int x, int y) {
		return x + y;
	}

}
