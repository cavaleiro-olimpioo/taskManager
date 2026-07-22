package com.olimpio.taskmanager.service;

import java.io.IOException;
import java.util.Collections;
import java.util.Objects;

import com.olimpio.taskmanager.util.JwtUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.security.SignatureException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

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

        if (!Objects.equals(request.getRequestURI(), "/login")) {
            if (!Objects.equals(request.getRequestURI(), "/validator")) {
                if (!Objects.equals(request.getRequestURI(), "/Sign")) {

                    String authHeader = request.getHeader("Authorization");
                    if (authHeader == null) {
                        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                        return;
                    }

                    String token = authHeader.substring("Bearer ".length());


                    try {
                        Claims nameFromToken = jwtUtil.validarToken(token);
                        String nameFromTokenSubjected = nameFromToken.getSubject();
                        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(nameFromTokenSubjected, null, Collections.emptyList());
                        SecurityContextHolder.getContext().setAuthentication(authentication);
                        filterChain.doFilter(request, response);
                    } catch (SignatureException e) {
                        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                    }
                }
            } else {
                filterChain.doFilter(request, response);
            }
        } else {
            filterChain.doFilter(request, response);
        }
    }

}
