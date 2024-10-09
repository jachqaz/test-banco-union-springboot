package persistence;

import model.commons.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISignUpDAO extends JpaRepository<Client, Long> {
    Client findClientByTipoDocumentoAndNumeroDocumento(String tipoDocumento, String numeroDocumento);
}