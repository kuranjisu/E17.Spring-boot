package com.example.E17.Spring.boot.component;


import com.example.E17.Spring.boot.entity.User;
import com.example.E17.Spring.boot.repository.UserRepository;
import io.micrometer.common.KeyValues;
import org.apache.tomcat.websocket.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.metrics.MetricsProperties;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder pEncoder;


/*
    @Override
    public Authentication authenticate(Authentication authentication)   {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        List<User> user = userRepository.findUserByUserName(username);
        System.out.println(username);
        System.out.println(password);
        System.out.println(userRepository.findByUserName(username).getUserName());
        System.out.println(userRepository.findByUserName(username).getPassword());




        if (user.size() > 0) {
            if (pEncoder.matches(password, user.get(0).getPassword())) {

                System.out.print("ffff");
                List<GrantedAuthority> authorities = new ArrayList<>();
                authorities.add(new SimpleGrantedAuthority(user.get(0).getRole()));
                return new UsernamePasswordAuthenticationToken(username, password, authorities);
            }else  {
                throw new BadCredentialsException("Invalid password");
            }
        } else {
            throw new BadCredentialsException("No user registered with this details");
        }
    }*/

/*    @Override
    public Authentication authenticate(Authentication authentication) {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        User user = userRepository.findByUserName(username);
        System.out.println(user.getPassword());
        try {
            if (pEncoder.matches(password, user.getPassword())) {
                List<GrantedAuthority> authorities = new ArrayList<>();
                authorities.add(new SimpleGrantedAuthority(user.getRole()));
                return new UsernamePasswordAuthenticationToken(username, password, authorities);
            }else  {
                throw new BadCredentialsException("Invalid password");
            }
        } catch (Exception e){
            throw new BadCredentialsException("No user registered with this details");
        }



    }*/





    @Override
    public Authentication authenticate(Authentication authentication)   {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        List<User> user = userRepository.findUserByUserName(username);
      System.out.println(username);
        System.out.println(password);
      /*  System.out.println(userRepository.findByUserName(username).getUserName());
        System.out.println(userRepository.findByUserName(username).getPassword());*/


        try {
                        System.out.println(userRepository.findByUserName(username).getRole());

            if (password.equals(userRepository.findByUserName(username).getPassword())) {
                List<GrantedAuthority> authorities = new ArrayList<>();
                authorities.add(new SimpleGrantedAuthority(userRepository.findByUserName(username).getRole()));
/*


               String userId = ((UserDetails) new UsernamePasswordAuthenticationToken(username, password, authorities).getPrincipal()).getUsername();

*/

                return new UsernamePasswordAuthenticationToken(username, password, authorities);
            }else  {
                throw new BadCredentialsException("Invalid password");
            }
        } catch (Exception e){
            throw new BadCredentialsException("No user registered with this details");
        }


    }


    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }


}