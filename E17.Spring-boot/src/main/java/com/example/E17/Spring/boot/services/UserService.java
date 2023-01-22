package com.example.E17.Spring.boot.services;

import com.example.E17.Spring.boot.entity.User;
import com.example.E17.Spring.boot.repository.ProductRepository;
import com.example.E17.Spring.boot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;
    public void addUser(User user){

        userRepository.save(user);
    }

    public User findUser(String userName){
        return  userRepository. findByUserName(userName);
    }


/*

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        List<GrantedAuthority> authorities = new ArrayList<>();
        if (user.isAdmin()) {
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        } else {
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }*/

}
