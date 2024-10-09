package fcd.controllers;

import business.services.ISignUpService;
import fcd.constants.FcdConstants;
import model.commons.Client;
import model.ws.SuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = FcdConstants.SIGNUP_CONTEXT)
@ComponentScan(basePackages = "business")
public class SignUpController {
    @Autowired
    private ISignUpService signUpService;

    @PostMapping(FcdConstants.SAVE_CLIENT)
    public ResponseEntity<SuccessResponse> saveClient(@RequestBody Client client) {
        signUpService.saveClient(client);
        return new ResponseEntity<>(new SuccessResponse(), HttpStatus.OK);
    }

    @PostMapping(FcdConstants.UPDATE_CLIENT)
    public ResponseEntity<SuccessResponse> updateClient(@RequestBody Client client) {
        signUpService.updateClient(client);
        return new ResponseEntity<>(new SuccessResponse(), HttpStatus.OK);
    }

    @GetMapping(FcdConstants.GET_CLIENT)
    public ResponseEntity<Client> getClient(@PathVariable String tipoDocumento, @PathVariable String numeroDocumento) {
        Client client = signUpService.getClient(tipoDocumento, numeroDocumento);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }
}
