package org.dblur.JarSoftTest.rest.service.categoryService;

import org.dblur.JarSoftTest.rest.model.Banner;
import org.dblur.JarSoftTest.rest.model.Category;

import java.util.List;

public interface CategoryServiceRest {

    List<Category> getAll();

    void add(Category category);
    void delete(Long id);
    void edit(Long id);

    Category getById(Long id);
    Category isDeleted(boolean delete);

}
