package org.dblur.JarSoftTest.dao.bannerDao;

import org.dblur.JarSoftTest.model.Banner;

import java.util.List;

public interface BannerDao {

    List<Banner> getAll();

    void add(Banner banner);
    void delete(Long id);
    void edit(Banner banner);

    Banner getById(Long id);
    Banner isDeleted(boolean delete);

    boolean isExist(String name);
}
