package br.org.furb.rmi.oferta;

import java.rmi.Naming;

import br.org.furb.model.Oferta;
import br.org.furb.util.Constantes;

public class HelloClient {
   public static void main(String[] args) {
      try {
         OfertaRMI obj = (OfertaRMI)Naming.lookup("//" + Constantes.IP_RMI + "/Oferta"); 

         Oferta oferta = new Oferta();
         oferta.setId(22);
         
         obj.criarOferta(oferta);
      } catch (Exception ex) {
         System.out.println("Exception: " + ex.getMessage());
      } 
   }
}
