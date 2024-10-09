package business.services;

import business.constants.BusinessConstants;
import model.commons.Client;
import model.commons.ModelConstants;
import model.ws.ExceptionResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import persistence.ISignUpDAO;

@Service
@ComponentScan(basePackages = "persistence")
public class SignUpServiceImpl implements ISignUpService {
    @Autowired
    private ISignUpDAO signUpDAO;

    private static final Logger LOGGER = LoggerFactory.getLogger(ModelConstants.NAME_LOGGER);

    /**
     * @return
     */
    @Override
    @Transactional(transactionManager = BusinessConstants.TRANSACTION_MANAGER, rollbackFor = Exception.class)
    public Boolean saveClient(Client client) throws ExceptionResponse {
        try {
            Client clientProcess = signUpDAO.save(client);
            LOGGER.info(ModelConstants.RESPONSE_BD, clientProcess);
            return !clientProcess.getIdTx().isEmpty();
        } catch (Exception e) {
            LOGGER.error(ModelConstants.TECHNICAL_ERRORS, e);
        }
        return false;
    }

    /**
     * @return
     */
    @Override
    @Transactional(transactionManager = BusinessConstants.TRANSACTION_MANAGER, rollbackFor = Exception.class)
    public Boolean updateClient(Client client) throws ExceptionResponse {
        try {
            if (!signUpDAO.findClientByTipoDocumentoAndNumeroDocumento(
                    client.getTipoDocumento(), client.getNumeroDocumento()
            ).getIdTx().isEmpty()) {
                Client clientProcess = signUpDAO.save(client);
                LOGGER.info(ModelConstants.RESPONSE_BD, clientProcess);
                return !clientProcess.getIdTx().isEmpty();
            }

        } catch (Exception e) {
            LOGGER.error(ModelConstants.TECHNICAL_ERRORS, e);
        }
        return false;
    }

    /**
     * @return
     */
    @Override
    @Transactional(transactionManager = BusinessConstants.TRANSACTION_MANAGER, rollbackFor = Exception.class)
    public Client getClient(String tipoDocumento, String numeroDocumento) throws ExceptionResponse {
        Client client = new Client();
        try {
            client = signUpDAO.findClientByTipoDocumentoAndNumeroDocumento(tipoDocumento, numeroDocumento);
            LOGGER.info(ModelConstants.RESPONSE_BD, client);
        } catch (Exception e) {
            LOGGER.error(ModelConstants.TECHNICAL_ERRORS, e);
        }
        return client;
    }
}
