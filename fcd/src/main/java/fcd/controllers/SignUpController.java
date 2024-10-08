package fcd.controllers;

import fcd.constants.FcdConstants;
import model.ws.SignUpRequest;
import model.ws.SuccessResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@org.springframework.web.bind.annotation.RestController
@RequestMapping(path = FcdConstants.SIGNUP_CONTEXT)
public class SignUpController {
    @PostMapping(FcdConstants.SAVE_CLIENT)
    public ResponseEntity<SuccessResponse> saveClient(SignUpRequest signUpRequest) {
        return new ResponseEntity<>(new SuccessResponse(), HttpStatus.OK);
    }

    @PostMapping(FcdConstants.UPDATE_CLIENT)
    public ResponseEntity<SuccessResponse> updateClient(SignUpRequest signUpRequest) {
        return new ResponseEntity<>(new SuccessResponse(), HttpStatus.OK);
    }

    @GetMapping(FcdConstants.GET_CLIENT)
    public ResponseEntity<SuccessResponse> getClient(SignUpRequest signUpRequest) {
        return new ResponseEntity<>(new SuccessResponse(), HttpStatus.OK);
    }
}
