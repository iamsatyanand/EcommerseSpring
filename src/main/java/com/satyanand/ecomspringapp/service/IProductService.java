package com.satyanand.ecomspringapp.service;

import com.satyanand.ecomspringapp.dto.ProductDTO;

import java.util.List;

public interface IProductService {
    List<ProductDTO> getAllProducts();
    ProductDTO getProductById(Integer id);
    ProductDTO createProduct(ProductDTO product);
    ProductDTO updateProduct(Integer id, ProductDTO product);
    void deleteProduct(Integer id);
}
