package com.satyanand.ecomspringapp.gateway;

import com.satyanand.ecomspringapp.dto.request.ProductDTO;
import com.satyanand.ecomspringapp.dto.response.ProductResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FakeStoreRestClientProductGateway implements IProductGateway{

    private final RestClient restClient;

    @Override
    public List<ProductResponseDTO> getAllProducts() {
        return restClient.get()
                .uri("products")
                .retrieve()
                .body(new ParameterizedTypeReference<>() {});
    }

    @Override
    public ProductResponseDTO getProductById(Long id) {
        return restClient.get()
                .uri("products/{id}", id)
                .retrieve()
                .body(ProductResponseDTO.class);
    }

    @Override
    public ProductResponseDTO createProduct(ProductDTO product) {
        return restClient.post()
                .uri("products")
                .body(product)
                .retrieve()
                .body(ProductResponseDTO.class);
    }

    @Override
    public ProductResponseDTO updateProduct(Integer id, ProductDTO product) {
        return restClient.put()
                .uri("products/{id}", id)
                .body(product)
                .retrieve()
                .body(ProductResponseDTO.class);
    }

    @Override
    public void deleteProduct(Integer id) {
        restClient.delete()
                .uri("products/{id}", id)
                .retrieve()
                .toBodilessEntity();

    }
}
