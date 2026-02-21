package com.satyanand.ecomspringapp.gateway;

import com.satyanand.ecomspringapp.dto.request.ProductDTO;
import com.satyanand.ecomspringapp.dto.response.ProductResponseDTO;

import java.util.List;

public interface IProductGateway {

    List<ProductResponseDTO> getAllProducts();
    ProductResponseDTO getProductById(Long id);
    ProductResponseDTO createProduct(ProductDTO product);
    ProductResponseDTO updateProduct(Integer id, ProductDTO product);
    void deleteProduct(Integer id);
}
