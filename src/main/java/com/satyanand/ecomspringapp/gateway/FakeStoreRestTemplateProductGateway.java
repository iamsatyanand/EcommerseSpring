package com.satyanand.ecomspringapp.gateway;

import com.satyanand.ecomspringapp.dto.ProductDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
@Primary
public class FakeStoreRestTemplateProductGateway implements IProductGateway {

    @Value("${external.api.base_url}")
    private String baseUrl;
    private final RestTemplate restTemplate;

    @Override
    public List<ProductDTO> getAllProducts() {
//        ResponseEntity<ProductDTO[]> response = restTemplate.getForEntity(baseUrl +"products", ProductDTO[].class);
//        return response.getBody() != null ? List.of(response.getBody()) : List.of();
        ProductDTO[] products = restTemplate.getForObject(baseUrl + "products", ProductDTO[].class);
        return products != null ? List.of(products) : List.of();
    }

    @Override
    public ProductDTO getProductById(Integer id) {
        return restTemplate.getForObject(baseUrl+ "products/{id}", ProductDTO.class, id);
    }

    @Override
    public ProductDTO createProduct(ProductDTO product) {
        return restTemplate.patchForObject(baseUrl+ "products", product, ProductDTO.class);
    }

    @Override
    public ProductDTO updateProduct(Integer id, ProductDTO product) {
        return restTemplate.patchForObject(baseUrl+ "products/{id}", product, ProductDTO.class, id);
    }

    @Override
    public void deleteProduct(Integer id) {
        restTemplate.delete(baseUrl+ "products/{id}", id);
    }
}
