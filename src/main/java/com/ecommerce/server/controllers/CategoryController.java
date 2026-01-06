package com.ecommerce.server.controllers;

import jakarta.servlet.http.HttpServletResponse;
import com.ecommerce.server.dto.request.CategoryDTO;
import com.ecommerce.server.entities.Category;
import com.ecommerce.server.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * @author Bao Pham
 * @created 31/03/2025
 * @project e-commerce application
 **/

@RestController
@RequestMapping("/api/category")
@CrossOrigin
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable(value = "id",required = true) UUID categoryId){
        Category category = categoryService.getCategory(categoryId);
        return new ResponseEntity<>(category, HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories(HttpServletResponse response){
        List<Category> categoryList = categoryService.getAllCategory();
        response.setHeader("Content-Range",String.valueOf(categoryList.size()));
        return new ResponseEntity<>(categoryList, HttpStatus.OK);

    }



    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody CategoryDTO categoryDto){
        Category category = categoryService.createCategory(categoryDto);
        return new ResponseEntity<>(category, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@RequestBody CategoryDTO categoryDto, @PathVariable(value = "id",required = true) UUID categoryId){
        Category updatedCategory = categoryService.updateCategory(categoryDto,categoryId);
        return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable(value = "id",required = true) UUID categoryId){
        categoryService.deleteCategory(categoryId);
        return ResponseEntity.ok().build();
    }
}
