package com.olimpio.taskmanager.service;

import java.io.IOException;

import com.olimpio.taskmanager.util.JwtUtil;
import io.jsonwebtoken.security.SignatureException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class FilterToken extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;

    public FilterToken(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");
        if (authHeader == null){
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        String token = authHeader.substring("Bearer ".length());



        try {
            jwtUtil.validarToken(token);

            filterChain.doFilter(request, response);
        } catch (SignatureException e){
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }

}
