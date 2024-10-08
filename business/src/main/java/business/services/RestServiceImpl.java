package business.services;

import com.gyf.clientes.pep.business.services.utils.ServiceUtils;
import com.gyf.clientes.pep.model.constant.KeyConstants;
import com.gyf.clientes.pep.model.entities.oracle.PepUser;
import com.gyf.clientes.pep.model.exception.CustomerPEPManagementException;
import com.gyf.clientes.pep.persistence.dao.IPepUserDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RestServiceImpl extends ServiceUtils implements IRestService {

    private static final Logger LOGGER = LoggerFactory.getLogger(KeyConstants.NAME_LOGGER);
    private static final String CLASS_NAME = "PepUserServiceImpl";
    @Autowired
    private IPepUserDAO pepUserDAO;

    @Override
    @Transactional(transactionManager = KeyConstants.TRANSACTION_MANAGER_PEP, rollbackFor = Exception.class)
    public Boolean findUser(String userName) throws CustomerPEPManagementException {
        PepUser pepUser = pepUserDAO.findByUserName(userName);

        try {

            if (pepUser == null) {
                buildCustomException(KeyConstants.USUARIO_NO_ENCONTRADO);
            }


        } catch (CustomerPEPManagementException e) {
            throw e;
        } catch (Exception e) {

            LOGGER.error(KeyConstants.ERROR_INESPERADO_APP, e);
            callCustomException(KeyConstants.COMMON_ERROR, e, CLASS_NAME);
        }
        return true;
    }

}
