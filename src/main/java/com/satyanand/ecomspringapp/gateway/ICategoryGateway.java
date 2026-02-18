package com.satyanand.ecomspringapp.gateway;

import com.satyanand.ecomspringapp.dto.CategoryDTO;
import com.satyanand.ecomspringapp.dto.FakeStoreCategoryResponseDTO;

import java.io.IOException;
import java.util.List;

public interface ICategoryGateway {

    List<CategoryDTO> getAllCategories() throws IOException;
}
