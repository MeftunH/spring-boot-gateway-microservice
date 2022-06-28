package com.sha.springbootgatewaymicroservice.controller;

import com.sha.springbootgatewaymicroservice.Model.User;
import com.sha.springbootgatewaymicroservice.Service.IAuthenticationService;
import com.sha.springbootgatewaymicroservice.Service.IUserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/authentication")
public class AuthenticationController {

    @Autowired
    private IAuthenticationService authenticationService;

    @Autowired
    private IUserService userService;

    @PostMapping("/sign-up")
    public ResponseEntity<?> signup(@RequestBody User user){
       if (userService.findByUsername(user.getUsername()).isPresent()) {
           return ResponseEntity.badRequest().body("User already exists");
       }
       return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }

    @PostMapping("/sign-in")
    public ResponseEntity<?> signIn(@RequestBody User user){
        return new ResponseEntity<>(authenticationService.getJWT(user), HttpStatus.OK);
    }

}
