
package br.org.furb.ws.usuario.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "criarUsuario", namespace = "http://usuario.ws.furb.org.br/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "criarUsuario", namespace = "http://usuario.ws.furb.org.br/")
public class CriarUsuario {

    @XmlElement(name = "arg0", namespace = "")
    private br.org.furb.model.Usuario arg0;

    /**
     * 
     * @return
     *     returns Usuario
     */
    public br.org.furb.model.Usuario getArg0() {
        return this.arg0;
    }

    /**
     * 
     * @param arg0
     *     the value for the arg0 property
     */
    public void setArg0(br.org.furb.model.Usuario arg0) {
        this.arg0 = arg0;
    }

}
