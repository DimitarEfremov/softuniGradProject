package com.mintleaf.config;

import com.mintleaf.repo.UserRepository;
import com.mintleaf.service.Impl.MintUserDetailService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    private final String rememberMeKey;

    public SecurityConfiguration( @Value("${mintleaf.remember.me.key}") String rememberMeKey) {
        this.rememberMeKey = rememberMeKey;
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.authorizeHttpRequests(
                authoriseRequests -> authoriseRequests
                        .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                        .requestMatchers("/", "/register", "/login", "/allRecipes", "/recipe", "/add-recipe", "/login-error").permitAll()
                        .anyRequest().authenticated()
        ).formLogin(
                formLogin -> {
                    formLogin
                            .loginPage("/login")
                            .usernameParameter("username")
                            .passwordParameter("password")
                            .defaultSuccessUrl("/")
                            .failureForwardUrl("/login-error");
                }
        ).logout(
                logout -> {
                    logout.logoutUrl("/logout")
                            .logoutSuccessUrl("/")
                            .invalidateHttpSession(true);
                }
        ).rememberMe(
                rememberMe ->{
                    rememberMe.key(rememberMeKey)
                            .rememberMeParameter("rememberMe")
                            .rememberMeCookieName("rememberMe");
                }
        );

        return httpSecurity.build();
    }

    @Bean
    public UserDetailsService userDetailService(UserRepository userRepository){
        return new MintUserDetailService(userRepository);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
