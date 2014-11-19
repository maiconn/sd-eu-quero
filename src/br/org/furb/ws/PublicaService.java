package br.org.furb.ws;

import javax.xml.ws.Endpoint;


public class PublicaService {
	public static void main(String[] args){
		Usuario service = new Usuario();
		Endpoint endpoint = Endpoint.publish("http://localhost:8080/hello", service);
	}
}
