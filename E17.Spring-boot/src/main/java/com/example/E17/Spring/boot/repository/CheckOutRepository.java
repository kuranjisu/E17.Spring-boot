package com.example.E17.Spring.boot.repository;
import com.example.E17.Spring.boot.entity.CheckOut;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface  CheckOutRepository extends JpaRepository<CheckOut, Long> {

    CheckOut findByProductId(Integer productId);

    CheckOut findByCheckOutId(Integer checkOut);
    List<CheckOut> findByUserName(String userName);

    CheckOut findByUserNameAndProductId(String userName, Integer productId);
}

