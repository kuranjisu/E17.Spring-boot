package com.example.E17.Spring.boot.services;

import com.example.E17.Spring.boot.entity.CheckOut;
import com.example.E17.Spring.boot.entity.Product;
import com.example.E17.Spring.boot.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;


@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> findByUserName(String userName){

        List<Product> products =productRepository.findByUserName(userName);


        Collections.sort(products, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return (int) (o1.getProductId() - o2.getProductId());
            }
        });
        return products;


    }





    public void addProduct(Product product){
        productRepository.save(product);
    }

    public List<Product> getAllProduct(){

        List<Product> products = productRepository.findAll();
        Collections.sort(products, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return (int) (o1.getProductId() - o2.getProductId());
            }
        });
        return products;
    }



    public Product findProduct(String id){


        Long longId = Long.parseLong(id);
        Optional<Product> product = productRepository.findById(longId);
        if(product.isPresent()) {
            return product.get();
        }
        else {
            throw new EntityNotFoundException("Task not found for the given id:"+id);
        }
    }

    public void deleteProduct(Product product){
        productRepository.delete(product);
    }




}
