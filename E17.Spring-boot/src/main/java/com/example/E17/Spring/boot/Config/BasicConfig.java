package com.example.E17.Spring.boot.Config;



import com.example.E17.Spring.boot.component.CustomAuthenticationProvider;
import com.example.E17.Spring.boot.entity.User;
import com.example.E17.Spring.boot.repository.UserRepository;
import com.example.E17.Spring.boot.services.CustomUserDetailsService;
import com.example.E17.Spring.boot.services.UserService;
import jakarta.servlet.Filter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
public class BasicConfig {


    @Autowired
    private UserRepository userRepository;

 @Autowired
    CustomUserDetailsService customUserDetailsService;


 CustomAuthenticationProvider cap = new CustomAuthenticationProvider();


    @Autowired
    private CustomAuthenticationProvider authProvider;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{





        http.authorizeRequests()
                .requestMatchers("/allProducts").hasAuthority("Seller")
                //.requestMatchers("/allCheckOut").hasAuthority("Customer")
                .requestMatchers("/index","/submitForm", "/allCheckOut").permitAll()

                .anyRequest()
                .authenticated()
                .and()
                .httpBasic()
                .and()
                .csrf()
                .disable()
                .formLogin()
                .successHandler((req, resp, auth) -> {
                    String userId = auth.getName();
                    req.getSession().setAttribute("userId", userId);
                    resp.sendRedirect("/allCheckOut");

                });


        return http.build();
    }



    @Bean
    public PasswordEncoder passwordEncoder(){
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        return encoder;
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("userId", request.getParameter("userId"));
    }




}