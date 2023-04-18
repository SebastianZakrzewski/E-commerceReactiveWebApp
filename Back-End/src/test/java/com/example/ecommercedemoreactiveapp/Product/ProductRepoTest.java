package com.example.ecommercedemoreactiveapp.Product;
import com.example.ecommercedemoreactiveapp.model.Product;
import com.example.ecommercedemoreactiveapp.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.LocalDateTime;

@DataMongoTest
@ExtendWith(SpringExtension.class)
public class ProductRepoTest {

    @Autowired ProductRepository repository;

    @Test
    public void shouldSaveProductToDataBase() {
        // Given
        Product product = Product.builder()
                .productName("Apple iPhone 14 Pro (128 GB)")
                .productBrand("Apple")
                .productCategory("Smartphones")
                .price(5199.00)
                .id(null)
                .dateTime(LocalDateTime.now())
                .build();
        Mono<Product> productMono = repository.save(product);
        StepVerifier.create(productMono)
                .assertNext(testProduct -> {
                    Assertions.assertNotNull(product.getId());
                }).expectComplete().verify();
    }


    @Test
    public void shouldGetProductFromDataBase() {

    }



}
