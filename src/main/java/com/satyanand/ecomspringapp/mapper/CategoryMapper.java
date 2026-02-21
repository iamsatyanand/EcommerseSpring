package com.satyanand.ecomspringapp.mapper;

import com.satyanand.ecomspringapp.dto.request.CategoryDTO;
import com.satyanand.ecomspringapp.dto.response.CategoryResponseDTO;
import com.satyanand.ecomspringapp.dto.response.CategorySummaryDTO;
import com.satyanand.ecomspringapp.entity.Category;

public class CategoryMapper {

    public static CategoryResponseDTO toResponseDTO(Category category, long productCount) {
        if (category == null) {
            return null;
        }

        return CategoryResponseDTO.builder()
                .id(category.getId())
                .name(category.getName())
                .createdAt(category.getCreatedAt())
                .updatedAt(category.getUpdatedAt())
                .productCount(productCount)
                .build();
    }

    public static Category toEntity(CategoryDTO categoryDTO) {
        if (categoryDTO == null) {
            return null;
        }

        return Category.builder()
                .name(categoryDTO.getName())
                .build();
    }

    public static CategorySummaryDTO toSummaryDTO(Category category) {
        if (category == null) {
            return null;
        }

        return CategorySummaryDTO.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }
}
