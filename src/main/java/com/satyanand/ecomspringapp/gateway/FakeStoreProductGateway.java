package com.satyanand.ecomspringapp.gateway;

import com.satyanand.ecomspringapp.dto.ProductDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FakeStoreProductGateway implements IProductGateway{

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
        return null;
    }

    @Override
    public ProductDTO createProduct(ProductDTO product) {
        return null;
    }

    @Override
    public ProductDTO updateProduct(Integer id, ProductDTO product) {
        return null;
    }

    @Override
    public void deleteProduct(Integer id) {

    }
}
