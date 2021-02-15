package org.dblur.JarSoftTest.dao.categoryDao;

import org.dblur.JarSoftTest.model.Category;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CategoryDaoImpl implements CategoryDao {

    @PersistenceContext
    private final EntityManager entityManager;

    public CategoryDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Category> getAll() {
        return entityManager
                .createQuery("FROM Category WHERE deleted=false").getResultList();
    }

    @Override
    public void add(Category category) {
        if (!isExist(category.getName())) {
            entityManager.persist(category);
        } else {
            System.out.println("exist");
        }
    }

    @Override
    public void delete(Long id) {
        Category category = entityManager.find(Category.class, id);
        category.setDeleted(true);
        entityManager.merge(category);
    }

    @Override
    public void edit(Long id) {
        Category category = entityManager.find(Category.class, id);
            entityManager.merge(category);
    }

    @Override
    public Category getById(Long id) {
        return entityManager.find(Category.class, id);
    }

    @Override
    public Category isDeleted(boolean delete) {
        return entityManager.find(Category.class, delete);
    }

    @Override
    public boolean isExist(String name) {
        return !entityManager.createQuery("SELECT name FROM Category WHERE name=:name")
                .setParameter("name", name).getResultList().isEmpty();
    }
}
