package com.satyanand.ecomspringapp.service;

import com.satyanand.ecomspringapp.dto.CategoryDTO;

import java.io.IOException;
import java.util.List;

public interface ICategoryService {
    List<CategoryDTO> getAllCategories() throws IOException;
}
