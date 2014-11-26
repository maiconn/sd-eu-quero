
package br.org.furb.ws.usuario.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "buscarUserResponse", namespace = "http://usuario.ws.furb.org.br/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "buscarUserResponse", namespace = "http://usuario.ws.furb.org.br/")
public class BuscarUserResponse {

    @XmlElement(name = "return", namespace = "")
    private br.org.furb.model.Usuario _return;

    /**
     * 
     * @return
     *     returns Usuario
     */
    public br.org.furb.model.Usuario getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(br.org.furb.model.Usuario _return) {
        this._return = _return;
    }

}
