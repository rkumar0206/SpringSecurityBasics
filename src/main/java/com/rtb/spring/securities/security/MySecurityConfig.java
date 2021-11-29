package com.rtb.spring.securities.security;

import com.rtb.spring.securities.filter.MySecurityFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;
    private final MyAuthenticationProvider authenticationProvider;

    public MySecurityConfig(BCryptPasswordEncoder passwordEncoder, MyAuthenticationProvider authenticationProvider) {
        this.passwordEncoder = passwordEncoder;
        this.authenticationProvider = authenticationProvider;
    }

    /*
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        // here we can configure the authentication manager i.e. userDetailService and password encoder

        InMemoryUserDetailsManager userDetailsService = new InMemoryUserDetailsManager();

        UserDetails user = User.withUsername("rohit").password(passwordEncoder.encode("12345"))
                .authorities("read")
                .build();

        userDetailsService.createUser(user);

        auth.userDetailsService(userDetailsService);
    }*/

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.authenticationProvider(authenticationProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // configure authentication type
        http.httpBasic();
        //http.formLogin();


        //http.authorizeRequests().anyRequest().authenticated(); // - authenticated user's can access any endpoint
        http.authorizeRequests().antMatchers("/hello").authenticated();  //- for /hello user needs to be authenticated
        //http.authorizeRequests().antMatchers("/hello").authenticated().anyRequest().denyAll();  // - only /hello is accessible by the authenticated users, rest endpoints are denied

        http.addFilterBefore(new MySecurityFilter(), BasicAuthenticationFilter.class);
    }
}
