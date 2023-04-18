package com.example.ecommercedemoreactiveapp.services;

import com.example.ecommercedemoreactiveapp.model.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IProductService {
    Mono<Product> addProduct(Product product);
    Flux<Product> getProducts();
    Mono<Void> deleteProduct(Product product);
    Mono<Product> update();
    Mono<Product> delete();

}
