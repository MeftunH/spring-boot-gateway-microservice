package com.sha.springbootgatewaymicroservice.Security;

import com.sha.springbootgatewaymicroservice.Model.User;
import com.sha.springbootgatewaymicroservice.Service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private IUserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userService.findByUsername(username)
                .orElseThrow(()-> new UsernameNotFoundException("User not found" + username));

        return new UserPrincipal(user.getId(), user.getUsername(), user.getPassword());
    }

}
