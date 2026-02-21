package com.satyanand.ecomspringapp.service.impl;

import com.satyanand.ecomspringapp.dto.request.CategoryDTO;
import com.satyanand.ecomspringapp.dto.response.CategoryResponseDTO;
import com.satyanand.ecomspringapp.dto.response.projection.CategorySummaryProjectionDTO;
import com.satyanand.ecomspringapp.gateway.ICategoryGateway;
import com.satyanand.ecomspringapp.service.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FakeCategoryService implements ICategoryService {

    private final ICategoryGateway categoryGateway;

    @Override
    public List<CategoryResponseDTO> getAllCategories() throws IOException {
        return categoryGateway.getAllCategories();
    }

    @Override
    public CategoryResponseDTO getCategoryByName(String name) {
        return null;
    }

//    @Override
//    public List<CategoryResponseDTO> getAllCategoriesWithProductCount() throws IOException {
//        return List.of();
//    }

    @Override
    public CategoryResponseDTO getCategoryById(Long id) throws IOException {
        return null;
    }

    @Override
    public List<CategoryResponseDTO> searchCategories(String query) {
        return List.of();
    }

    @Override
    public List<CategorySummaryProjectionDTO> getAllCategoryNames() {
        return List.of();
    }

    @Override
    public CategoryResponseDTO createCategory(CategoryDTO category) {
        return null;
    }
}
