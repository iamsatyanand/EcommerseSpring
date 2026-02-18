package com.satyanand.ecomspringapp.service.impl;

import com.satyanand.ecomspringapp.dto.CategoryDTO;
import com.satyanand.ecomspringapp.gateway.ICategoryGateway;
import com.satyanand.ecomspringapp.service.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService implements ICategoryService {

    private final ICategoryGateway categoryGateway;

    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
        return categoryGateway.getAllCategories();
    }
}
