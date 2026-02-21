package com.satyanand.ecomspringapp.controller;

import com.satyanand.ecomspringapp.dto.request.CategoryDTO;
import com.satyanand.ecomspringapp.dto.response.CategoryResponseDTO;
import com.satyanand.ecomspringapp.dto.response.projection.CategorySummaryProjectionDTO;
import com.satyanand.ecomspringapp.service.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(path = "/api/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final ICategoryService categoryService;

    @PostMapping
    public ResponseEntity<CategoryResponseDTO> createCategory(
             @RequestBody CategoryDTO dto) {
        CategoryResponseDTO createdCategory = categoryService.createCategory(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCategory);
    }

    @GetMapping
    public ResponseEntity<List<CategoryResponseDTO>> getCategories() throws IOException {
        List<CategoryResponseDTO> categories = categoryService.getAllCategories();
        return ResponseEntity.ok((categories));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponseDTO> getCategoryById(@PathVariable Long id) throws IOException {
        CategoryResponseDTO category = categoryService.getCategoryById(id);
        return ResponseEntity.ok(category);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<CategoryResponseDTO> getCategoryByName(@PathVariable String name) {
        return ResponseEntity.ok(categoryService.getCategoryByName(name));
    }

    @GetMapping("/search")
    public ResponseEntity<List<CategoryResponseDTO>> searchCategories(@RequestParam String query) throws IOException {
//        List<CategoryResponseDTO> categories = categoryService.getAllCategories(); // Get all categories
//        List<CategoryResponseDTO> filteredCategories = categories.stream()
//                .filter(c -> c.getName().toLowerCase().contains(query.toLowerCase())) // Filter by name
//                .toList();
//        return ResponseEntity.ok(filteredCategories);
        List<CategoryResponseDTO> categories = categoryService.searchCategories(query);
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/names")
    public ResponseEntity<List<CategorySummaryProjectionDTO>> getCategoryNames() {
        return ResponseEntity.ok(categoryService.getAllCategoryNames());
    }

}
