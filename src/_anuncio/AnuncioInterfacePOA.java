package _anuncio;


/**
* _anuncio/AnuncioInterfacePOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ./br/org/furb/corba/anuncio/AnuncioCORBA.idl
* S�bado, 29 de Novembro de 2014 18h42min46s BRST
*/

public abstract class AnuncioInterfacePOA extends org.omg.PortableServer.Servant
 implements _anuncio.AnuncioInterfaceOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("getAnuncios", new java.lang.Integer (0));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // _anuncio/AnuncioInterface/getAnuncios
       {
         int idUsuario = in.read_long ();
         String $result = null;
         $result = this.getAnuncios (idUsuario);
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:anuncio/AnuncioInterface:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public AnuncioInterface _this() 
  {
    return AnuncioInterfaceHelper.narrow(
    super._this_object());
  }

  public AnuncioInterface _this(org.omg.CORBA.ORB orb) 
  {
    return AnuncioInterfaceHelper.narrow(
    super._this_object(orb));
  }


} // class AnuncioInterfacePOA
