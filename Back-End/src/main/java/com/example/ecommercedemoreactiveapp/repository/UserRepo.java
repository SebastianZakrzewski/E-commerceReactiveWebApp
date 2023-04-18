package com.example.ecommercedemoreactiveapp.repository;
import com.example.ecommercedemoreactiveapp.model.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;


public interface UserRepo extends ReactiveMongoRepository<User,String> {
}
