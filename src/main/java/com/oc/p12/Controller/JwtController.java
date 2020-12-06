package com.oc.p12.Controller;

import com.oc.p12.Bean.AuthenticationRequest;
import com.oc.p12.Bean.Dto.Authentication.AuthUser;
import com.oc.p12.Entity.Account;
import com.oc.p12.Service.AccountService;
import com.oc.p12.Service.JwtService;
import com.oc.p12.Service.MyUserDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:4200")
@RestController
public class JwtController {
    @Autowired
    private JwtService jwtTokenService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private AccountService accountService;


    @Autowired
    private MyUserDetailsService userDetailsService;

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        }
        catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }


        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String jwt = jwtTokenService.generateToken(userDetails);
        Account account = accountService.findAccountByEmail(authenticationRequest.getUsername());
        AuthUser authUser= new AuthUser();
        authUser.setId(account.getAccountId());
        authUser.setEmail(account.getEmail());
        authUser.setName(account.getName());
        authUser.setSurname(account.getSurname());
        authUser.setToken(jwt);
        authUser.setDepartureHour(account.getDepartureTime());
        return ResponseEntity.ok(authUser);
    }
}
