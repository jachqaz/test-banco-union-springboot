package business.services;

import business.constants.BusinessConstants;
import model.commons.Client;
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

    /**
     * @return
     */
    @Override
    @Transactional(transactionManager = BusinessConstants.TRANSACTION_MANAGER, rollbackFor = Exception.class)
    public Boolean saveClient(Client client) {
        try {
            signUpDAO.save(client);
        } catch (Exception e) {
            e.getMessage();
        }
        return true;
    }

    /**
     * @return
     */
    @Override
    @Transactional(transactionManager = BusinessConstants.TRANSACTION_MANAGER, rollbackFor = Exception.class)
    public Boolean updateClient(Client client) {
        try {
            signUpDAO.save(client);
        } catch (Exception e) {
            e.getMessage();
        }
        return true;
    }

    /**
     * @return
     */
    @Override
    @Transactional(transactionManager = BusinessConstants.TRANSACTION_MANAGER, rollbackFor = Exception.class)
    public Client getClient(String tipoDocumento, String numeroDocumento) {
        Client client = new Client();
        try {
            client = signUpDAO.findClientByTipoDocumentoAndNumeroDocumento(tipoDocumento, numeroDocumento);
        } catch (Exception e) {
            e.getMessage();
        }
        return client;
    }
}
