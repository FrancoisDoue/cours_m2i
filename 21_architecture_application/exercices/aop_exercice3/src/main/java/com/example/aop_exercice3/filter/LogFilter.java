package com.example.aop_exercice3.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class LogFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        String method = request.getMethod();
        long timeStamp = System.currentTimeMillis();
        String ipAddress = request.getRemoteAddr();

        System.out.println("[ " + method + " - " + requestURI + " ] at " +  timeStamp + " - [ ip: " + ipAddress + " ]");
        doFilter(request, response, filterChain);
    }
}
