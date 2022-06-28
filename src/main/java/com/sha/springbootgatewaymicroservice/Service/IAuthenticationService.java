package com.sha.springbootgatewaymicroservice.Service;

import com.sha.springbootgatewaymicroservice.Model.User;

public interface IAuthenticationService {
    String getJWT(User request);
}
