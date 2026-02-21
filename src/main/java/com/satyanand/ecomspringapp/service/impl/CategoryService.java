package com.satyanand.ecomspringapp.service.impl;

import com.satyanand.ecomspringapp.dto.request.CategoryDTO;
import com.satyanand.ecomspringapp.dto.response.CategoryResponseDTO;
import com.satyanand.ecomspringapp.dto.response.projection.CategorySummaryProjectionDTO;
import com.satyanand.ecomspringapp.entity.Category;
import com.satyanand.ecomspringapp.mapper.CategoryMapper;
import com.satyanand.ecomspringapp.repository.CategoryRepository;
import com.satyanand.ecomspringapp.service.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
@Primary
public class CategoryService implements ICategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public CategoryResponseDTO getCategoryById(Long id) throws IOException {
        return categoryRepository.findByIdWithProductCount(id)
                .orElseThrow( () -> new RuntimeException("Category not found with id: " + id));
    }

    @Override
    public CategoryResponseDTO createCategory(CategoryDTO category) {
        Category categoryEntity = CategoryMapper.toEntity(category);
        categoryEntity = categoryRepository.save(categoryEntity);
        return CategoryMapper.toResponseDTO(categoryEntity, 0);
    }

    @Override
    public List<CategoryResponseDTO> getAllCategories() throws IOException {
        return categoryRepository.getAllCategoriesWithProducts();

    }

    @Override
    public CategoryResponseDTO getCategoryByName(String name) {
        return categoryRepository.findByNameWithProductCount(name)
                .orElseThrow( () -> new RuntimeException("Category not found with name: " + name));
    }

    @Override
    public List<CategoryResponseDTO> searchCategories(String query) {
        return categoryRepository.searchWithProductCount(query);
    }

    @Override
    public List<CategorySummaryProjectionDTO> getAllCategoryNames() {
        return categoryRepository.findAllBy();
    }
}
