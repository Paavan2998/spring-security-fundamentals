package com.example.springsecurityfundamentals.config;

import com.example.springsecurityfundamentals.config.security.filters.CustomAuthenticationFilter;
import com.example.springsecurityfundamentals.services.JpaUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

/**
 * Created by Paavan Shah on 19-06-2023.
 */
@Configuration
public class WebSecurityConfig {

    private final CustomAuthenticationFilter customAuthenticationFilter;

    public WebSecurityConfig(CustomAuthenticationFilter customAuthenticationFilter) {
        this.customAuthenticationFilter = customAuthenticationFilter;
    }

    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.httpBasic(Customizer.withDefaults())
                .addFilterBefore(customAuthenticationFilter, BasicAuthenticationFilter.class)
                .authorizeRequests().anyRequest().authenticated()
                .and().build();

//        .addFilterAt() it replaces the UsernamePasswordAuthenticationFilter with the customAuthentication filter
//        .and().authenticationManager() can be used to create custom authentication manager, or we can create a bean of type AuthenticationManager like we did in this project.
//        .and().authenticationProvider() id doesn't override the AuthenticationProvider, it adds one more to the collection
//        .authorizeRequest().anyRequest().authenticated() tells HttpSecurity to authorize any request through the customAuthenticationFilter by default it allows all requests.


    }

    @Bean
    DaoAuthenticationProvider getDaoBean(JpaUserDetailsService jpaUserDetailsService){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(jpaUserDetailsService);
        daoAuthenticationProvider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
//        After Spring Security 5 if we want to use NoOpPasswordEncoder we need to prefix the password with '{noop}'
        return daoAuthenticationProvider;
    }
}
