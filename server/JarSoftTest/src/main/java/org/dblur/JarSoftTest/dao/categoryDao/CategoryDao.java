package org.dblur.JarSoftTest.dao.categoryDao;

import org.dblur.JarSoftTest.model.Category;

import java.util.List;

public interface CategoryDao {

    List<Category> getAll();

    void add(Category category);
    void delete(Long id);
    void edit(Long id);

    Category getById(Long id);
    Category isDeleted(boolean delete);

    boolean isExist(String name);
}