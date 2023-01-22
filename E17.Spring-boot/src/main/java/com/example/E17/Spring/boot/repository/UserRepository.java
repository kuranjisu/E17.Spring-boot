package com.example.E17.Spring.boot.repository;

import com.example.E17.Spring.boot.entity.Product;
import com.example.E17.Spring.boot.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {


   User findByUserName(String userName);

   List<User> findUserByUserName(String userName);


   // User findByUserCredentals(String name, String pass);



}
