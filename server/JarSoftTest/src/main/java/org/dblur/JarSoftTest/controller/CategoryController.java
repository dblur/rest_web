package org.dblur.JarSoftTest.controller;

import org.dblur.JarSoftTest.model.Category;
import org.dblur.JarSoftTest.service.categoryService.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping( "/allCategories")
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categoryList = categoryService.getAll();
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }

    @GetMapping("categories/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.getById(id));
    }

    @PostMapping("/addCategory")
    @Transactional
    public ResponseEntity<Category> addCategory(HttpEntity<Category> httpEntity) {
        Category category = httpEntity.getBody();
        categoryService.add(category);
        return new ResponseEntity<> (HttpStatus.OK);
    }

    @GetMapping("/deleteCategory/{id}")
    @Transactional
    public ResponseEntity<Category> deleteCategory(@PathVariable Long id) {
        categoryService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/editCategory/{id}")
    @Transactional
    public ResponseEntity<Category> getCategoryForEdit(@PathVariable Long id) {
        return  ResponseEntity.status(HttpStatus.OK).body(categoryService.getById(id));
    }

    @PostMapping("/editCategory/{id}")
    @Transactional
    public ResponseEntity<Category> editCategory(@PathVariable Long id, HttpEntity<Category> httpEntity) {
        Category category = httpEntity.getBody();
        assert category != null;
        categoryService.edit(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
