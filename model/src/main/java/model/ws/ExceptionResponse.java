package model.ws;


import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class ExceptionResponse extends Exception {

    private String idTx;
    private String error;

    public ExceptionResponse(String idTx, String error, Throwable cause) {
        super(cause);
        this.idTx = idTx;
        this.error = error;
    }

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
