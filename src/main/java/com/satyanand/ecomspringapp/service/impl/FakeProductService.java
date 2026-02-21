package com.satyanand.ecomspringapp.service.impl;

import com.satyanand.ecomspringapp.dto.request.ProductDTO;
import com.satyanand.ecomspringapp.dto.response.ProductResponseDTO;
import com.satyanand.ecomspringapp.gateway.IProductGateway;
import com.satyanand.ecomspringapp.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FakeProductService implements IProductService {

    private final IProductGateway productGateway; // inject the gateway

    @Override
    public List<ProductResponseDTO> getAllProducts() {
        return productGateway.getAllProducts();
    }

    @Override
    public ProductResponseDTO getProductById(Long id) {
        return productGateway.getProductById(id);
    }

    @Override
    public ProductResponseDTO createProduct(ProductDTO product) {
        return productGateway.createProduct(product);
    }

    @Override
    public ProductResponseDTO updateProduct(Integer id, ProductDTO product) {
        return productGateway.updateProduct(id, product);
    }

    @Override
    public void deleteProduct(Integer id) {
        productGateway.deleteProduct(id);
    }
}
