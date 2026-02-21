package com.satyanand.ecomspringapp.service.impl;

import com.satyanand.ecomspringapp.dto.request.ProductDTO;
import com.satyanand.ecomspringapp.dto.response.ProductResponseDTO;
import com.satyanand.ecomspringapp.entity.Category;
import com.satyanand.ecomspringapp.entity.Product;
import com.satyanand.ecomspringapp.mapper.ProductMapper;
import com.satyanand.ecomspringapp.repository.CategoryRepository;
import com.satyanand.ecomspringapp.repository.ProductRepository;
import com.satyanand.ecomspringapp.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public List<ProductResponseDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();

        return products.stream()
                .map(ProductMapper::toResponseDTO)
                .toList();
    }

    @Override
    public ProductResponseDTO getProductById(Long id) {
        return ProductMapper.toResponseDTO(productRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Product not found with id: " + id)
        ));
    }

    @Override
    public ProductResponseDTO createProduct(ProductDTO productDTO) {

        Category category = categoryRepository.findById(productDTO.getCategoryId()).orElseThrow(
                () -> new RuntimeException("Category not found with id: " + productDTO.getCategoryId())
        );

        Product product = ProductMapper.toEntity(productDTO, category);
        Product savedProduct = productRepository.save(product);



        return ProductMapper.toResponseDTO(savedProduct);
    }

    @Override
    public ProductResponseDTO updateProduct(Integer id, ProductDTO product) {
        return null;
    }

    @Override
    public void deleteProduct(Integer id) {

    }
}
