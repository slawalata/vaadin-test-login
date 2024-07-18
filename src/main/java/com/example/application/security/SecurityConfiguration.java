package com.example.application.security;

import com.example.application.views.login.LoginView;
import com.vaadin.flow.spring.security.VaadinWebSecurity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends VaadinWebSecurity {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(
                authorize -> authorize.requestMatchers(new AntPathRequestMatcher("/images/*.png")).permitAll());

        // Icons from the line-awesome addon
        http.authorizeHttpRequests(authorize -> authorize
                .requestMatchers(new AntPathRequestMatcher("/line-awesome/**/*.svg")).permitAll());

        super.configure(http);
        setLoginView(http, LoginView.class);
    }

    /**
     * Demo UserDetailsManager which only provides two hardcoded
     * in memory users and their roles.
     * NOTE: This shouldn't be used in real world applications.
     */
    @Bean
    public UserDetailsManager userDetailsService() {
        var alice = User.builder()
                .username("daniel")
                // password = password with this hash, don't tell anybody :-)
                .password("$2a$10$yD.uqapqW2xkVrEQm8sSE.n7rLeEX/cQs3oDslAvjpVmuWkdgABjG")
                .roles(Roles.ITADMIN)
                .build();
        var bob = User.builder()
                .username("sanga")
                // password = password with this hash, don't tell anybody :-)
                .password("$2a$10$yD.uqapqW2xkVrEQm8sSE.n7rLeEX/cQs3oDslAvjpVmuWkdgABjG")
                .roles(Roles.FRONTDESK)
                .build();
        var admin = User.builder()
                .username("anderias")
                // password = password with this hash, don't tell anybody :-)
                .password("$2a$10$yD.uqapqW2xkVrEQm8sSE.n7rLeEX/cQs3oDslAvjpVmuWkdgABjG")
                .roles(Roles.ACCOUNTING)
                .build();
        return new InMemoryUserDetailsManager(alice, bob, admin);
    }

}
