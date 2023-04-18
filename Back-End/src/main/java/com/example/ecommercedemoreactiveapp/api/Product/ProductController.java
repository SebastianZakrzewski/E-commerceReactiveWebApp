package com.example.ecommercedemoreactiveapp.api.Product;

import com.example.ecommercedemoreactiveapp.model.Product;
import com.example.ecommercedemoreactiveapp.services.IProductService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import java.net.URI;
import java.util.List;

@RestController
public class ProductController {

    final IProductService service;

    public ProductController(IProductService service) {
        this.service = service;
    }

    @GetMapping(path = "/product")
    public Mono<ResponseEntity<List<Product>>> getProducts() {
        return service.
                getProducts().
                collectList().
                map(products -> ResponseEntity.ok(products)).
                defaultIfEmpty(ResponseEntity.
                        notFound().
                        build());
    }

    @PostMapping(path = "/product/add")
    public Mono<ResponseEntity<Product>> addtProducts(@RequestBody Product product) {
        return service.addProduct(product).map(addProduct -> {
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(URI.create("/product/add"));
            return new ResponseEntity<Product>(product,headers, HttpStatus.CREATED);
        });
    }



}
