package com.wieik.ssitvseries.Service;


import com.wieik.ssitvseries.model.AuthenticationRequest;
import com.wieik.ssitvseries.model.AuthenticationResponse;
import com.wieik.ssitvseries.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {


    private AuthenticationManager authenticationManager;
    private MyUserDetailService myUserDetailService;
    private JwtUtil jwtUtil;

    @Autowired
    public AuthenticationServiceImpl(AuthenticationManager authenticationManager, MyUserDetailService myUserDetailService, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.myUserDetailService = myUserDetailService;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public ResponseEntity<?> getAuthenticationToken(AuthenticationRequest authenticationRequest) throws Exception{
        try {
            System.out.println("Jestem tu 1");
            System.out.println("Mail: "+ authenticationRequest.getMail() + "   " + " password: "+ authenticationRequest.getPassword());
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getMail(), authenticationRequest.getPassword()));
            System.out.println("Jestem tu 2");
        } catch (BadCredentialsException e) {
            System.out.println("Jestem tu 2");
            System.out.println("Incorrect username or password: "+ authenticationRequest.getMail()+ " " +  authenticationRequest.getPassword());
            e.printStackTrace();
            throw new Exception("Incorrent username or password", e);
        }
        System.out.println("Jestem tu 3");
        System.out.println("Mail:" + authenticationRequest.getMail());
        final UserDetails userDetails = myUserDetailService.loadUserByUsername(authenticationRequest.getMail());
        final String jwt = jwtUtil.generateToken(userDetails);
        System.out.println("JWT: " + jwt);
        return ResponseEntity.ok(new AuthenticationResponse(jwt, 1000 ,authenticationRequest.getMail()));
    }
}
