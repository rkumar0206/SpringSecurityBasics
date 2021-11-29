package com.rtb.spring.securities.filter;

import org.springframework.web.filter.GenericFilterBean;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//public class MySecurityFilter implements OncePerRequestFilter {

// public class MySecurityFilter extends GenericFilterBean {   // in this the username and password will be already injected

public class MySecurityFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {

        System.out.println("Before");
        filterChain.doFilter(request, response);
        System.out.println("After");
    }

  /*  @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {


    }*/

}
