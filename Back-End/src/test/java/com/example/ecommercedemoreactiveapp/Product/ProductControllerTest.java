package com.example.ecommercedemoreactiveapp.Product;
import com.example.ecommercedemoreactiveapp.model.Product;
import com.example.ecommercedemoreactiveapp.services.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.reactive.server.SecurityMockServerConfigurers;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;


@ExtendWith(SpringExtension.class)
@WebFluxTest
public class ProductControllerTest {

    @MockBean
    ProductService service;
    Product product;

    @Autowired
    private WebTestClient webClient;

    @BeforeEach
    void create() {
         product = Product.builder()
                .productName("Apple iPhone 14 Pro (128 GB)")
                .productBrand("Apple")
                .productCategory("Smartphones")
                .price(5199.00)
                .id(null)
                .dateTime(LocalDateTime.now())
                .build();
    }

    @Test
    @WithMockUser(username = "user",roles = "USER")
    public void shouldCreateNewProductAfterHitTheEndpoint() {
        Mockito.when(service.addProduct(product)).thenReturn(Mono.just(product));
        webClient.mutateWith(SecurityMockServerConfigurers.csrf()).post()
                .uri("/product/add")
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(product),Product.class)
                .exchange()
                .expectStatus().isCreated();
        Mockito.verify(service).addProduct(product);
    }

    @Test
    @WithMockUser(username = "user",roles = "USER")
    public void shouldGetProductAfterHitTheEndpoint() {
        Mockito.when(service.getProducts()).thenReturn(Flux.just(product));
        webClient.mutateWith(SecurityMockServerConfigurers.csrf()).get()
                .uri("/product").
                exchange()
                .expectStatus().isOk();
        Mockito.verify(service).getProducts();

    }

}
