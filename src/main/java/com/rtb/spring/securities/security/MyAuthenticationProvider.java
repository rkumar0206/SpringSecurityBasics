package com.rtb.spring.securities.security;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MyAuthenticationProvider  implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        // here we add our custom authentication logic

        String userName = authentication.getName();
        String password = authentication.getCredentials().toString();

        if (userName.equals("rohit") && password.equals("12345"))
        {
            return new UsernamePasswordAuthenticationToken(userName, password, List.of());
        }else {
            throw new BadCredentialsException("Invalid username or password");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {

        // this will check if our authentication provider supports the type of authentication
        // therefore here we have to provide the authentication type we are using
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
