package com.example.E17.Spring.boot.services;

import com.example.E17.Spring.boot.entity.CheckOut;
import com.example.E17.Spring.boot.entity.Product;
import com.example.E17.Spring.boot.repository.CheckOutRepository;
import com.example.E17.Spring.boot.repository.CheckOutRepository1;
import com.example.E17.Spring.boot.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.DocFlavor;
import java.util.*;


@Service
public class CheckOutService {
    @Autowired
    private CheckOutRepository checkOutRepository;


    @Autowired
    private CheckOutRepository1 checkOutRepository1;


public CheckOut findByProductId(Integer productId){
   return checkOutRepository.findByProductId(productId);
}

public CheckOut findByCheckOutId(Integer checkOutId){
    return checkOutRepository.findByCheckOutId(checkOutId);
}



     public CheckOut findByUserNameId(String userName, Integer prodId){


        return checkOutRepository.findByUserNameAndProductId(userName,prodId);
    }



    public void deleteCheckOut(CheckOut checkOut){

    checkOutRepository.delete(checkOut);

    }


    public List<CheckOut> getAllCheckOut(){


       return checkOutRepository1.findAll();
    }







    public List<CheckOut> findByUserName(String userName){

        List<CheckOut> checkOuts =checkOutRepository.findByUserName(userName);

        Collections.sort(checkOuts, new Comparator<CheckOut>() {
            @Override
            public int compare(CheckOut o1, CheckOut o2) {
                return o1.getCheckOutId() - o2.getCheckOutId();
            }
        });
        return checkOuts;



    }


    public CheckOut searchByProduct(Integer productId){

        return (CheckOut) checkOutRepository.findByProductId(productId);
    }


    public void addCheckOut(CheckOut checkOut){
        checkOutRepository.save(checkOut);
    }
}
