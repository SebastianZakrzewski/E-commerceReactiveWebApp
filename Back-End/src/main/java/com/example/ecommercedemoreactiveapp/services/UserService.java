package com.example.ecommercedemoreactiveapp.services;
import com.example.ecommercedemoreactiveapp.model.User;
import com.example.ecommercedemoreactiveapp.repository.UserRepo;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class UserService  {
    private final UserRepo repository;

    public UserService(UserRepo repository) {
        this.repository = repository;

    }
    public Mono<User> getUser(String id) {
        return repository.findById(id);
    }

    public Mono<User> createUser(User user) {
        return repository.save(user);
    }

}
