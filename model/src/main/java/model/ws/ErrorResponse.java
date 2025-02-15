package model.ws;


import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class ErrorResponse {

    private String idTx;
    private String error;

    public ErrorResponse(String idTx, String error) {
        this.idTx = idTx;
        this.error = error;
    }

    public ErrorResponse(String error) {
        this.idTx = "";
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
