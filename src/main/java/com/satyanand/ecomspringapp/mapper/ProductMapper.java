package com.satyanand.ecomspringapp.mapper;

import com.satyanand.ecomspringapp.dto.request.ProductDTO;
import com.satyanand.ecomspringapp.dto.response.ProductResponseDTO;
import com.satyanand.ecomspringapp.entity.Category;
import com.satyanand.ecomspringapp.entity.Product;

public class ProductMapper {

    public static ProductResponseDTO toResponseDTO(Product product) {
        if (product == null) {
            return null;
        }

        return ProductResponseDTO.builder()
                .id(product.getId())
                .title(product.getTitle())
                .price(product.getPrice())
                .description(product.getDescription())
                .color(product.getColor())
                .image(product.getImage())
                .discount(product.getDiscount())
                .model(product.getModel())
                .brand(product.getBrand())
                .popular(product.isPopular())
                .category(
                        product.getCategory() != null?
                                CategoryMapper.toSummaryDTO(product.getCategory())
                                : null
                )
                .createdAt(product.getCreatedAt())
                .updatedAt(product.getUpdatedAt())
                .build();
    }

    public static Product toEntity(ProductDTO productDTO, Category category) {
        if (productDTO == null) {
            return null;
        }

        return Product.builder()
                .title(productDTO.getTitle())
                .price(productDTO.getPrice())
                .description(productDTO.getDescription())
                .color(productDTO.getColor())
                .image(productDTO.getImage())
                .discount(productDTO.getDiscount())
                .model(productDTO.getModel())
                .brand(productDTO.getBrand())
                .popular(productDTO.isPopular())
                .category(category)
                .build();

    }
}
