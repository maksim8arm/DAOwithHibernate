package com.example.dao_hibernate.security;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .and()
                .authorizeHttpRequests().antMatchers("/fage").permitAll()
                .and()
                .authorizeHttpRequests().antMatchers("/fcity").hasAnyAuthority("read")
                .and()
                .authorizeHttpRequests().anyRequest().authenticated();
    }
}
