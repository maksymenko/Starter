package com.sm.starter.config;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@EnableOAuth2Sso
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity web)
            throws Exception {

        web.ignoring().antMatchers("/resources/**", "/books/");
    }

    @Override
    protected void configure(HttpSecurity http)
            throws Exception {
        http.antMatcher("/**")
                .logout().logoutSuccessUrl("/").and()
                .authorizeRequests()
                .antMatchers("/login**").permitAll()
                .anyRequest().authenticated()
                .and()
                .csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                .and()
                .formLogin().disable();
    }
}
