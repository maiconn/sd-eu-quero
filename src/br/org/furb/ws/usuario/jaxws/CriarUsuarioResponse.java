
package br.org.furb.ws.usuario.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "criarUsuarioResponse", namespace = "http://usuario.ws.furb.org.br/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "criarUsuarioResponse", namespace = "http://usuario.ws.furb.org.br/")
public class CriarUsuarioResponse {

    @XmlElement(name = "return", namespace = "")
    private boolean _return;

    /**
     * 
     * @return
     *     returns boolean
     */
    public boolean isReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(boolean _return) {
        this._return = _return;
    }

}
