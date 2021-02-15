package org.dblur.JarSoftTest.service.categoryService;

import org.dblur.JarSoftTest.dao.categoryDao.CategoryDao;
import org.dblur.JarSoftTest.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

    private final CategoryDao categoryDao;

    @Autowired
    public CategoryServiceImpl(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Override
    public List<Category> getAll() {
        return categoryDao.getAll();
    }

    @Override
    public void add(Category category) {
        categoryDao.add(category);
    }

    @Override
    public void delete(Long id) {
        categoryDao.delete(id);
    }

    @Override
    public void edit(Long id) {
        categoryDao.edit(id);
    }

    @Override
    public Category getById(Long id) {
        return categoryDao.getById(id);
    }

    @Override
    public Category isDeleted(boolean delete) {
        return categoryDao.isDeleted(delete);
    }
}
