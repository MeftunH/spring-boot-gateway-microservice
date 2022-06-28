package com.sha.springbootgatewaymicroservice.Service;

import com.sha.springbootgatewaymicroservice.Model.User;
import com.sha.springbootgatewaymicroservice.Security.UserPrincipal;
import com.sha.springbootgatewaymicroservice.Security.jwt.IJwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService implements IAuthenticationService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private IJwtProvider jwtProvider;

    @Override
    public String getJWT(User request){
     Authentication authentication = authenticationManager
                                     .authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(),
                                                   request.getPassword()));
     UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();

      return jwtProvider.generateToken(userPrincipal);
    }
}
