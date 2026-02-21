package com.satyanand.ecomspringapp.gateway;

import com.satyanand.ecomspringapp.dto.request.CategoryDTO;
import com.satyanand.ecomspringapp.dto.response.CategoryResponseDTO;
import com.satyanand.ecomspringapp.dto.response.FakeStoreCategoryResponseDTO;
import com.satyanand.ecomspringapp.gateway.api.FakeStoreCategoryApi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FakeStoreCategoryGateway implements ICategoryGateway{

    private final FakeStoreCategoryApi fakeStoreCategoryApi;

    @Override
    public List<CategoryResponseDTO> getAllCategories() throws IOException {
        FakeStoreCategoryResponseDTO response = fakeStoreCategoryApi.getAllFakeCategories().execute().body();
        if(response == null) {
            throw new IOException("Failed to fetch categories from Fake Store API");
        }
        return response.getCategories().stream()
                .map(category -> CategoryResponseDTO.builder()
                        .name(category)
                        .build()).toList();

    }
}
