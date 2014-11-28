
package br.org.furb.ws.usuario.cliente;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the br.org.furb.ws.usuario.cliente package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _BuscarUserResponse_QNAME = new QName("http://usuario.ws.furb.org.br/", "buscarUserResponse");
    private final static QName _Exception_QNAME = new QName("http://usuario.ws.furb.org.br/", "Exception");
    private final static QName _BuscarUser_QNAME = new QName("http://usuario.ws.furb.org.br/", "buscarUser");
    private final static QName _BuscarResponse_QNAME = new QName("http://usuario.ws.furb.org.br/", "buscarResponse");
    private final static QName _AutenticarResponse_QNAME = new QName("http://usuario.ws.furb.org.br/", "autenticarResponse");
    private final static QName _Autenticar_QNAME = new QName("http://usuario.ws.furb.org.br/", "autenticar");
    private final static QName _CriarUsuario_QNAME = new QName("http://usuario.ws.furb.org.br/", "criarUsuario");
    private final static QName _CriarUsuarioResponse_QNAME = new QName("http://usuario.ws.furb.org.br/", "criarUsuarioResponse");
    private final static QName _Buscar_QNAME = new QName("http://usuario.ws.furb.org.br/", "buscar");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.org.furb.ws.usuario.cliente
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link BuscarUserResponse }
     * 
     */
    public BuscarUserResponse createBuscarUserResponse() {
        return new BuscarUserResponse();
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link BuscarUser }
     * 
     */
    public BuscarUser createBuscarUser() {
        return new BuscarUser();
    }

    /**
     * Create an instance of {@link BuscarResponse }
     * 
     */
    public BuscarResponse createBuscarResponse() {
        return new BuscarResponse();
    }

    /**
     * Create an instance of {@link AutenticarResponse }
     * 
     */
    public AutenticarResponse createAutenticarResponse() {
        return new AutenticarResponse();
    }

    /**
     * Create an instance of {@link Autenticar }
     * 
     */
    public Autenticar createAutenticar() {
        return new Autenticar();
    }

    /**
     * Create an instance of {@link CriarUsuario }
     * 
     */
    public CriarUsuario createCriarUsuario() {
        return new CriarUsuario();
    }

    /**
     * Create an instance of {@link CriarUsuarioResponse }
     * 
     */
    public CriarUsuarioResponse createCriarUsuarioResponse() {
        return new CriarUsuarioResponse();
    }

    /**
     * Create an instance of {@link Buscar }
     * 
     */
    public Buscar createBuscar() {
        return new Buscar();
    }

    /**
     * Create an instance of {@link Usuario }
     * 
     */
    public Usuario createUsuario() {
        return new Usuario();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BuscarUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://usuario.ws.furb.org.br/", name = "buscarUserResponse")
    public JAXBElement<BuscarUserResponse> createBuscarUserResponse(BuscarUserResponse value) {
        return new JAXBElement<BuscarUserResponse>(_BuscarUserResponse_QNAME, BuscarUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Exception }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://usuario.ws.furb.org.br/", name = "Exception")
    public JAXBElement<Exception> createException(Exception value) {
        return new JAXBElement<Exception>(_Exception_QNAME, Exception.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BuscarUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://usuario.ws.furb.org.br/", name = "buscarUser")
    public JAXBElement<BuscarUser> createBuscarUser(BuscarUser value) {
        return new JAXBElement<BuscarUser>(_BuscarUser_QNAME, BuscarUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BuscarResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://usuario.ws.furb.org.br/", name = "buscarResponse")
    public JAXBElement<BuscarResponse> createBuscarResponse(BuscarResponse value) {
        return new JAXBElement<BuscarResponse>(_BuscarResponse_QNAME, BuscarResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AutenticarResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://usuario.ws.furb.org.br/", name = "autenticarResponse")
    public JAXBElement<AutenticarResponse> createAutenticarResponse(AutenticarResponse value) {
        return new JAXBElement<AutenticarResponse>(_AutenticarResponse_QNAME, AutenticarResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Autenticar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://usuario.ws.furb.org.br/", name = "autenticar")
    public JAXBElement<Autenticar> createAutenticar(Autenticar value) {
        return new JAXBElement<Autenticar>(_Autenticar_QNAME, Autenticar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CriarUsuario }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://usuario.ws.furb.org.br/", name = "criarUsuario")
    public JAXBElement<CriarUsuario> createCriarUsuario(CriarUsuario value) {
        return new JAXBElement<CriarUsuario>(_CriarUsuario_QNAME, CriarUsuario.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CriarUsuarioResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://usuario.ws.furb.org.br/", name = "criarUsuarioResponse")
    public JAXBElement<CriarUsuarioResponse> createCriarUsuarioResponse(CriarUsuarioResponse value) {
        return new JAXBElement<CriarUsuarioResponse>(_CriarUsuarioResponse_QNAME, CriarUsuarioResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Buscar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://usuario.ws.furb.org.br/", name = "buscar")
    public JAXBElement<Buscar> createBuscar(Buscar value) {
        return new JAXBElement<Buscar>(_Buscar_QNAME, Buscar.class, null, value);
    }

}
