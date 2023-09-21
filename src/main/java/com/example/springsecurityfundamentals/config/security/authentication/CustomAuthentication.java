package com.example.springsecurityfundamentals.config.security.authentication;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import javax.security.auth.Subject;
import java.util.Collection;

/**
 * Created by Paavan Shah on 21-09-2023.
 */
public class CustomAuthentication implements Authentication {

    private final boolean authentication;
    private final String key;

    public CustomAuthentication(boolean authentication, String key) {
        this.authentication = authentication;
        this.key = key;
    }

    @Override
    public boolean isAuthenticated() {
        return authentication;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getDetails() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public boolean implies(Subject subject) {
        return Authentication.super.implies(subject);
    }

    public boolean isAuthentication() {
        return authentication;
    }

    public String getKey() {
        return key;
    }
}
