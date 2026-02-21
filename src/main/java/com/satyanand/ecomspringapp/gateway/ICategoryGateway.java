package com.satyanand.ecomspringapp.gateway;

import com.satyanand.ecomspringapp.dto.request.CategoryDTO;
import com.satyanand.ecomspringapp.dto.response.CategoryResponseDTO;

import java.io.IOException;
import java.util.List;

public interface ICategoryGateway {

    List<CategoryResponseDTO> getAllCategories() throws IOException;
}
