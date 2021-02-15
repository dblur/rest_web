package org.dblur.JarSoftTest.rest.service.bannerService;

import org.dblur.JarSoftTest.rest.model.Banner;

import java.util.List;

public interface BannerServiceRest {

    List<Banner> getAll();

    void add(Banner banner);
    void delete(Long id);
    void edit(Banner banner);

    Banner getById(Long id);
    Banner isDeleted(boolean delete);

}
