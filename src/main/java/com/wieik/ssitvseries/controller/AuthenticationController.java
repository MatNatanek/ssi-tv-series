package com.wieik.ssitvseries.controller;



import com.wieik.ssitvseries.Service.AuthenticationService;
import com.wieik.ssitvseries.model.AuthenticationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/authenticate")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthenticationController {

    private AuthenticationService authenticationService;

    @Autowired
    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
        return authenticationService.getAuthenticationToken(authenticationRequest);
    }

}
