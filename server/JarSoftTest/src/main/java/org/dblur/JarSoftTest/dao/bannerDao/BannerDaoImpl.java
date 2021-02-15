package org.dblur.JarSoftTest.dao.bannerDao;

import org.dblur.JarSoftTest.model.Banner;
import org.dblur.JarSoftTest.model.Category;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class BannerDaoImpl implements BannerDao{

    @PersistenceContext
    private final EntityManager entityManager;

    public BannerDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Banner> getAll() {
        return entityManager
                .createQuery("FROM Banner WHERE deleted=false").getResultList();
    }

    @Override
    public void add(Banner banner) {
        if (!isExist(banner.getName())) {
            entityManager.persist(banner);
        } else {
            System.out.println("banner exist");
        }
    }

    @Override
    public void delete(Long id) {
        Banner banner = entityManager.find(Banner.class, id);
        banner.setDeleted(true);
        entityManager.merge(banner);
    }

    @Override
    public void edit(Banner banner) {
        entityManager.merge(banner);
    }

    @Override
    public Banner getById(Long id) {
        return entityManager.find(Banner.class, id);
    }

    @Override
    public Banner isDeleted(boolean delete) {
        return entityManager.find(Banner.class, delete);
    }

    @Override
    public boolean isExist(String name) {
        return !entityManager.createQuery("SELECT name FROM Banner WHERE name=:name")
                .setParameter("name", name).getResultList().isEmpty();
    }
}
