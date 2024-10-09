package business.services;


import model.commons.Client;

public interface ISignUpService {

    Boolean saveClient(Client client);

    Boolean updateClient(Client client);

    Client getClient(String tipoDocumento, String numeroDocumento);
}
