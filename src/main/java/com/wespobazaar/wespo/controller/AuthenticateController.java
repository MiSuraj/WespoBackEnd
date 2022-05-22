package com.wespobazaar.wespo.controller;

import com.wespobazaar.wespo.exceptions.UserNotFoundException;
import com.wespobazaar.wespo.security.JwtRequest;
import com.wespobazaar.wespo.security.JwtResponse;
import com.wespobazaar.wespo.security.JwtUtils;
import com.wespobazaar.wespo.service.userServices.UserDetailsServiceImpl;
import com.wespobazaar.wespo.service.userServices.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class AuthenticateController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Autowired
    private JwtUtils jwtUtils;




    @PostMapping("/generate-token")
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        // Authenticate the user and password

        try {
            System.out.println("AUTHENTICATION HAS BEEN STARTED");

            authenticate(jwtRequest.getUsername(), jwtRequest.getPassword());


            System.out.println("AUTHENTICATION HAS BEEN DONE");


        } catch (UserNotFoundException e) {
            e.printStackTrace();
            throw new Exception("User not found ");
        }

        /////////////after authentication  done

         //load User By UserName From UserDetail Service
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(jwtRequest.getUsername());
        //after loading username we have to generate token
        String token = this.jwtUtils.generateToken(userDetails);



        System.out.println("TOKEN IS GENERATED : " + token);
        //after generating token we have to send the token as a response
        return ResponseEntity.ok(new JwtResponse(token));


    }




    private void authenticate(String username, String password) throws Exception {

        try {
            System.out.println("authenticate method");

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

            System.out.println("authenticate method ends");

        } catch (DisabledException e) {
            throw new Exception("USER DISABLED " + e.getMessage());
        } catch (BadCredentialsException e) {
            throw new Exception("Invalid Credentials " + e.getMessage());
        }
    }
}
