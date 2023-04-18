package com.example.ecommercedemoreactiveapp.api.Authentication;
import com.example.ecommercedemoreactiveapp.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin
public class AuthController {
    final private ReactiveUserDetailsService users;

    public AuthController(ReactiveUserDetailsService users) {
        this.users = users;
    }

   @PostMapping("/user/login")
   public Mono<ResponseEntity> login(@RequestBody User user) {
       System.out.println(user.getEmail());
        Mono<UserDetails> foundUser = users.findByUsername(user.getEmail());
        foundUser.flatMap(authenticateUser -> {
            if (authenticateUser != null) {
                if (authenticateUser.getPassword() == user.getPassword()) {
                    return Mono.just(
                            ResponseEntity.ok(user)
                    );
                }
            }
            return Mono.just(ResponseEntity.status(HttpStatus.UNAUTHORIZED));
        });

       return Mono.just(ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null));
   }


}
