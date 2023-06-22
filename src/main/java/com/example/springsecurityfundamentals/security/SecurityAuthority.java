package com.example.springsecurityfundamentals.security;

import com.example.springsecurityfundamentals.entities.Authority;
import org.springframework.security.core.GrantedAuthority;

/**
 * Created by Paavan Shah on 22-06-2023.
 */
public class SecurityAuthority implements GrantedAuthority {

    private final Authority authority;

    public SecurityAuthority(Authority authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return authority.getName();
    }
}
