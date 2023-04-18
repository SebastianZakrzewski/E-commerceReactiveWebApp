package com.example.ecommercedemoreactiveapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
@Document
@Data
@Builder
public class Product {

        @Id
        private String id;

        @JsonProperty("product_name")
        private String productName;

        @JsonProperty("product_brand")
        private String productBrand;

        @JsonProperty("product_category")
        private String productCategory;

        private Double price;

        @JsonProperty("date_time")
        private LocalDateTime dateTime;

        @JsonProperty("product_image")
        private String productImage;


}
