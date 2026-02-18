package com.satyanand.ecomspringapp.service.impl;

import com.satyanand.ecomspringapp.dto.ProductDTO;
import com.satyanand.ecomspringapp.gateway.IProductGateway;
import com.satyanand.ecomspringapp.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {

    private final IProductGateway productGateway; // inject the gateway

    @Override
    public List<ProductDTO> getAllProducts() {
        return productGateway.getAllProducts();
    }

    @Override
    public ProductDTO getProductById(Integer id) {
        return productGateway.getProductById(id);
    }

    @Override
    public ProductDTO createProduct(ProductDTO product) {
        return productGateway.createProduct(product);
    }

    @Override
    public ProductDTO updateProduct(Integer id, ProductDTO product) {
        return productGateway.updateProduct(id, product);
    }

    @Override
    public void deleteProduct(Integer id) {
        productGateway.deleteProduct(id);
    }
}
