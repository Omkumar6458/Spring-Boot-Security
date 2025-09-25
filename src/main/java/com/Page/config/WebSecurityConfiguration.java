package com.Page.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/delete/**").hasRole("MANAGER")
                .requestMatchers("/addEmployee", "/listEmployees").authenticated()
                .anyRequest().permitAll()
            )
            .formLogin(form -> form
                .loginPage("/login")
                .successHandler((request, response, authentication) -> {
                    boolean isManager = authentication.getAuthorities().stream()
                            .anyMatch(a -> a.getAuthority().equals("ROLE_MANAGER"));
                    if (isManager) {
                        response.sendRedirect("/EMS/listEmployees");
                    } else {
                        response.sendRedirect("/EMS/addEmployee");
                    }
                })
                .permitAll()
            )
            .logout(logout -> logout.permitAll())
            .csrf(csrf -> csrf.disable());

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails manager = User.withUsername("manager")
                .password("{noop}manager123")
                .roles("MANAGER")
                .build();

        UserDetails user = User.withUsername("OM")
                .password("{noop}OM")
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(manager, user);
    }
}
