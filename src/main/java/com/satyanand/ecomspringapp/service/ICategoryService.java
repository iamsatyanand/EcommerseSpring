package com.satyanand.ecomspringapp.service;

import com.satyanand.ecomspringapp.dto.request.CategoryDTO;
import com.satyanand.ecomspringapp.dto.response.CategoryResponseDTO;
import com.satyanand.ecomspringapp.dto.response.projection.CategorySummaryProjectionDTO;

import java.io.IOException;
import java.util.List;

public interface ICategoryService {
    List<CategoryResponseDTO> getAllCategories() throws IOException;

    CategoryResponseDTO getCategoryByName(String name);

    CategoryResponseDTO createCategory(CategoryDTO category);

    CategoryResponseDTO getCategoryById(Long id) throws IOException;

    List<CategoryResponseDTO> searchCategories(String query);

    List<CategorySummaryProjectionDTO> getAllCategoryNames();
}
