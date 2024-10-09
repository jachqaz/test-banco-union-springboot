package fcd.controllers;

import business.services.ISignUpService;
import fcd.constants.FcdConstants;
import model.commons.Client;
import model.commons.ModelConstants;
import model.ws.ErrorResponse;
import model.ws.ExceptionResponse;
import model.ws.SuccessResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = FcdConstants.SIGNUP_CONTEXT)
@ComponentScan(basePackages = "business")
public class SignUpController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ModelConstants.NAME_LOGGER);

    @Autowired
    private ISignUpService signUpService;

    @PostMapping(FcdConstants.SAVE_CLIENT)
    public ResponseEntity saveClient(@RequestBody Client client) throws ExceptionResponse {
        LOGGER.info(ModelConstants.REQUEST, FcdConstants.SAVE_CLIENT, client);
        String errorMessage = getErrorMessage(client);
        ResponseEntity responseEntity;
        if (!errorMessage.isEmpty()) {
            responseEntity = new ResponseEntity<>(
                    new ErrorResponse(
                            client.getIdTx(),
                            errorMessage
                    ), HttpStatus.BAD_REQUEST);
            LOGGER.error(ModelConstants.RESPONSE_SEND, responseEntity);
            return responseEntity;
        }
        if (!signUpService.saveClient(client)) {
            responseEntity = new ResponseEntity<>(
                    new ErrorResponse(
                            client.getIdTx(),
                            String.format("Cliente %s no fue almacenado.",
                                    client.getNumeroDocumento())
                    ), HttpStatus.BAD_REQUEST);
            LOGGER.error(ModelConstants.RESPONSE_SEND, responseEntity);
            return responseEntity;
        }
        responseEntity = new ResponseEntity<>(new SuccessResponse(client.getIdTx(),
                String.format("Cliente %s almacenado de forma exitosa.",
                        client.getNumeroDocumento())), HttpStatus.OK);

        LOGGER.info(ModelConstants.RESPONSE_SEND, responseEntity);
        return responseEntity;
    }

    @PostMapping(FcdConstants.UPDATE_CLIENT)
    public ResponseEntity updateClient(@RequestBody Client client) throws ExceptionResponse {
        LOGGER.info(ModelConstants.REQUEST, FcdConstants.UPDATE_CLIENT, client);
        String errorMessage = getErrorMessage(client);
        ResponseEntity responseEntity;
        if (!errorMessage.isEmpty()) {
            responseEntity = new ResponseEntity<>(
                    new ErrorResponse(
                            client.getIdTx(),
                            errorMessage
                    ), HttpStatus.BAD_REQUEST);
            LOGGER.error(ModelConstants.RESPONSE_SEND, responseEntity);
            return responseEntity;
        }
        if (!signUpService.updateClient(client)) {
            responseEntity = new ResponseEntity<>(
                    new ErrorResponse(
                            client.getIdTx(),
                            String.format("Cliente %s %s. No se encuentra registrado.",
                                    client.getTipoDocumento(), client.getNumeroDocumento())
                    ), HttpStatus.BAD_REQUEST);
            LOGGER.error(ModelConstants.RESPONSE_SEND, responseEntity);
            return responseEntity;
        }
        responseEntity = new ResponseEntity<>(new SuccessResponse(client.getIdTx(),
                String.format("Cliente %s actualizado de forma exitosa.",
                        client.getNumeroDocumento())), HttpStatus.OK);
        LOGGER.info(ModelConstants.RESPONSE_SEND, responseEntity);
        return responseEntity;
    }

    @GetMapping(FcdConstants.GET_CLIENT)
    public ResponseEntity getClient(@PathVariable String tipoDocumento, @PathVariable String numeroDocumento) throws ExceptionResponse {
        LOGGER.info(ModelConstants.REQUEST, FcdConstants.GET_CLIENT, tipoDocumento, numeroDocumento);
        Client client = signUpService.getClient(tipoDocumento, numeroDocumento);
        ResponseEntity responseEntity;
        if (client == null) {
            responseEntity = new ResponseEntity<>(
                    new ErrorResponse(
                            String.format("Cliente %s %s. No se encuentra registrado.",
                                    tipoDocumento, numeroDocumento)
                    ), HttpStatus.BAD_REQUEST);
            LOGGER.error(ModelConstants.RESPONSE_SEND, responseEntity);
            return responseEntity;
        }
        responseEntity = new ResponseEntity<>(client, HttpStatus.OK);
        LOGGER.info(ModelConstants.RESPONSE_SEND, responseEntity);
        return responseEntity;
    }

    String getErrorMessage(Client client) {
        StringBuilder message = new StringBuilder("Campos ");
        if (client.getIdTx().isEmpty()) {
            message.append("IdTx, ");
        } else if (client.getTipoDocumento().isEmpty()) {
            message.append("TipoDocumento, ");
        } else if (client.getNumeroDocumento().isEmpty()) {
            message.append("NumeroDocumento, ");
        } else if (client.getPrimerNombre().isEmpty()) {
            message.append("primerNombre, ");
        } else if (client.getPrimerApellido().isEmpty()) {
            message.append("primerApellido, ");
        } else if (client.getTeléfono().isEmpty()) {
            message.append("teléfono, ");
        } else if (client.getCorreElectronico().isEmpty()) {
            message.append("correElectronico, ");
        }
        message = new StringBuilder(message.substring(0, message.length() - 2));
        message.append(". Son obligatorios.");
        if (!client.getCorreElectronico().isEmpty() &&
                !client.getCorreElectronico().contains("@")) {
            message.append(" Campo correElectronico, no cumple con la estructura de un correo electrónico valido.");
        }
        if (message.toString().contains("Campo. Son obligatorios.")) {
            return "";
        }
        return message.toString();
    }
}
