package model.ws;


import java.io.Serializable;

public class SuccessResponse implements Serializable {

    private String idTx;
    private String mensaje;

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
