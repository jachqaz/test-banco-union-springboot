package model.ws;


import java.io.Serializable;

public class ErrorResponse implements Serializable {

    private String idTx;
    private String error;

    public String getIdTx() {
        return idTx;
    }

    public void setIdTx(String idTx) {
        this.idTx = idTx;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
