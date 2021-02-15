package org.dblur.JarSoftTest.rest.controller;

import org.dblur.JarSoftTest.rest.model.Banner;
import org.dblur.JarSoftTest.rest.model.Category;
import org.dblur.JarSoftTest.rest.service.categoryService.CategoryServiceRestImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

    private final CategoryServiceRestImpl categoryService;

    @Autowired
    public CategoryController(CategoryServiceRestImpl categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public List<Category> getAllCategories() {
        return categoryService.getAll();
    }

    @GetMapping("/category/{id}")
    public Category getCategoryById(@PathVariable Long id) {
        return categoryService.getById(id);
    }

    @GetMapping("/delete/category/{id}")
    public String deleteCategory(@PathVariable Long id) {
        categoryService.delete(id);
        return "success";
    }

    @PostMapping("/add/category")
    public String addCategory(@RequestBody Category category) {
        categoryService.add(category);
        return "redirect:/";
    }

    @GetMapping("/edit/category/{id}")
    public Category getEditCategory(@PathVariable Long id) {
        categoryService.edit(id);
        return categoryService.getById(id);
    }


}
