package org.dblur.JarSoftTest.service.bannerService;

import org.dblur.JarSoftTest.model.Banner;

import java.util.List;

public interface BannerService {

    List<Banner> getAll();

    void add(Banner banner);
    void delete(Long id);
    void edit(Banner banner);

    Banner getById(Long id);
    Banner isDeleted(boolean delete);

}
