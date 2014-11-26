package BoasVindas;

import org.omg.CosNaming.*;
import org.omg.CORBA.*;

public class Msg_Boas_VindasImpl extends Msg_Boas_VindasPOA
{  
  public String boas_vindas () { 
	  return "Bem-vindo ao CORBA"; 
  };
  

}