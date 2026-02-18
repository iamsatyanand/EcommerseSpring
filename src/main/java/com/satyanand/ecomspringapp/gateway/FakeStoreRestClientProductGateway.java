package com.satyanand.ecomspringapp.gateway;

import com.satyanand.ecomspringapp.dto.ProductDTO;
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
    public List<ProductDTO> getAllProducts() {
        return restClient.get()
                .uri("products")
                .retrieve()
                .body(new ParameterizedTypeReference<>() {});
    }

    @Override
    public ProductDTO getProductById(Integer id) {
        return restClient.get()
                .uri("products/{id}", id)
                .retrieve()
                .body(ProductDTO.class);
    }

    @Override
    public ProductDTO createProduct(ProductDTO product) {
        return restClient.post()
                .uri("products")
                .body(product)
                .retrieve()
                .body(ProductDTO.class);
    }

    @Override
    public ProductDTO updateProduct(Integer id, ProductDTO product) {
        return restClient.put()
                .uri("products/{id}", id)
                .body(product)
                .retrieve()
                .body(ProductDTO.class);
    }

    @Override
    public void deleteProduct(Integer id) {
        restClient.delete()
                .uri("products/{id}", id)
                .retrieve()
                .toBodilessEntity();

    }
}
