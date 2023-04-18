package com.example.ecommercedemoreactiveapp.repository;


import com.example.ecommercedemoreactiveapp.model.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ProductRepository extends ReactiveMongoRepository<Product,String> {




}
