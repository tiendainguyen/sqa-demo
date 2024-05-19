package com.example.demo.config;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException, IOException {
        AtomicReference<String> redirectUrl = new AtomicReference<>("/home-page"); // Default redirect
        // Check user roles to determine the redirect URL
        authentication.getAuthorities().forEach(authority -> {
            System.out.println("Role is:" + authority.getAuthority());
            if (authority.getAuthority().equals("ROLE_ADMIN")) {
                redirectUrl.set("/computers");
            } else if (authority.getAuthority().equals("ROLE_CUSTOMER")) {
                redirectUrl.set("/computers_user");
            }
        });

        response.sendRedirect(redirectUrl.get());
    }
}
