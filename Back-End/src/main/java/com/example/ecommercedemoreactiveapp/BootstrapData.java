package com.example.ecommercedemoreactiveapp;
import com.example.ecommercedemoreactiveapp.model.Product;
import com.example.ecommercedemoreactiveapp.services.IProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class BootstrapData implements CommandLineRunner {

    private final IProductService service;

    public BootstrapData(IProductService service) {
        this.service = service;
    }

    @Override
    public void run(String... args) throws Exception {

        Product product1 = Product.builder().productName("Iphone 14")
                .productBrand("Apple")
                .productCategory("Smartphones")
                .price(1400.00)
                .dateTime(LocalDateTime.now()).build();

        service.addProduct(product1);

    }
}
