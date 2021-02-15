package org.dblur.JarSoftTest.service.categoryService;

import org.dblur.JarSoftTest.model.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getAll();

    void add(Category category);
    void delete(Long id);
    void edit(Long id);

    Category getById(Long id);
    Category isDeleted(boolean delete);

}
