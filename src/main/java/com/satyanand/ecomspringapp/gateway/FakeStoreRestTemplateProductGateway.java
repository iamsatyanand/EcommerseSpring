package com.satyanand.ecomspringapp.gateway;

import com.satyanand.ecomspringapp.dto.request.ProductDTO;
import com.satyanand.ecomspringapp.dto.response.ProductResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
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
    public List<ProductResponseDTO> getAllProducts() {
//        ResponseEntity<ProductDTO[]> response = restTemplate.getForEntity(baseUrl +"products", ProductDTO[].class);
//        return response.getBody() != null ? List.of(response.getBody()) : List.of();
        ProductResponseDTO[] products = restTemplate.getForObject(baseUrl + "products", ProductResponseDTO[].class);
        return products != null ? List.of(products) : List.of();
    }

    @Override
    public ProductResponseDTO getProductById(Long id) {
        return restTemplate.getForObject(baseUrl+ "products/{id}", ProductResponseDTO.class, id);
    }

    @Override
    public ProductResponseDTO createProduct(ProductDTO product) {
        return restTemplate.patchForObject(baseUrl+ "products", product, ProductResponseDTO.class);
    }

    @Override
    public ProductResponseDTO updateProduct(Integer id, ProductDTO product) {
        return restTemplate.patchForObject(baseUrl+ "products/{id}", product, ProductResponseDTO.class, id);
    }

    @Override
    public void deleteProduct(Integer id) {
        restTemplate.delete(baseUrl+ "products/{id}", id);
    }
}
