package com.wieik.ssitvseries.Service;

import com.wieik.ssitvseries.model.AuthenticationRequest;
import org.springframework.http.ResponseEntity;

public interface AuthenticationService {
    ResponseEntity<?> getAuthenticationToken(AuthenticationRequest authenticationRequest) throws Exception;

}
