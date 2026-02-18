package com.satyanand.ecomspringapp;

import com.satyanand.ecomspringapp.dto.ProductDTO;
import com.satyanand.ecomspringapp.gateway.IProductGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class EcomSpringAppApplicationTests {

    @Autowired
    private IProductGateway productGateway;

    @Test
    void contextLoads() {
    }

    @Test
    public void testGetAllProducts() {
        List<ProductDTO> products = productGateway.getAllProducts();
        products.forEach(System.out::println);
//        assert products != null;
//        assert !products.isEmpty();
    }



}
