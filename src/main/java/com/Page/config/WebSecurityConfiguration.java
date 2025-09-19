package com.Page.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/delete**").hasRole("MANAGER")
                .anyRequest().permitAll()
            )
            .httpBasic(withDefaults())   // enable Basic Auth
            .csrf(csrf -> csrf.disable());
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails manager = User
                .withUsername("manager")        // ✅ correct builder
                .password("{noop}manager123")
                .roles("MANAGER")
                .build();

        UserDetails user = User
                .withUsername("user")           // ✅ correct builder
                .password("{noop}user123")
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(manager, user);
    }
}
