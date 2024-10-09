package model.ws;


import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
public class SuccessResponse implements Serializable {

    private String idTx;
    private String mensaje;

    public SuccessResponse(String idTx, String mensaje) {
        this.idTx = idTx;
        this.mensaje = mensaje;
    }

    public String getIdTx() {
        return idTx;
    }

    public void setIdTx(String idTx) {
        this.idTx = idTx;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
