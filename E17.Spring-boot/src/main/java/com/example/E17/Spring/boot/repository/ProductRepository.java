package com.example.E17.Spring.boot.repository;
import com.example.E17.Spring.boot.entity.CheckOut;
import com.example.E17.Spring.boot.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface  ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByUserName(String userName);
}
