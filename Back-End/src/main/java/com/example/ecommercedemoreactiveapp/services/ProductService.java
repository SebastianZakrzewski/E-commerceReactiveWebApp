package com.example.ecommercedemoreactiveapp.services;
import com.example.ecommercedemoreactiveapp.model.Product;
import com.example.ecommercedemoreactiveapp.repository.ProductRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductService implements IProductService {
    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }
    @Override
    public Mono<Product> addProduct(Product product) {
        return repository.save(product);
    }
    @Override
    public Flux<Product> getProducts() {
        return repository.findAll();
    }

    @Override
    public Mono<Void> deleteProduct(Product product) {
        return repository.delete(product);
    }


    @Override
    public Mono<Product> update() {
        return null;
    }

    @Override
    public Mono<Product> delete() {
        return null;
    }
}
