package business.services;


import model.commons.Client;
import model.ws.ExceptionResponse;

public interface ISignUpService {

    Boolean saveClient(Client client) throws ExceptionResponse;

    Boolean updateClient(Client client) throws ExceptionResponse;

    Client getClient(String tipoDocumento, String numeroDocumento) throws ExceptionResponse;
}
