package org.dblur.JarSoftTest.service.bannerService;

import org.dblur.JarSoftTest.dao.bannerDao.BannerDao;
import org.dblur.JarSoftTest.model.Banner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BannerServiceImpl implements BannerService{

    private final BannerDao bannerDao;

    @Autowired
    public BannerServiceImpl(BannerDao bannerDao) {
        this.bannerDao = bannerDao;
    }

    @Override
    public List<Banner> getAll() {
        return bannerDao.getAll() ;
    }

    @Override
    public void add(Banner banner) {
            bannerDao.add(banner);
    }

    @Override
    public void delete(Long id) {
        bannerDao.delete(id);
    }

    @Override
    public void edit(Banner banner) {
        bannerDao.edit(banner);
    }

    @Override
    public Banner getById(Long id) {
        return bannerDao.getById(id);
    }

    @Override
    public Banner isDeleted(boolean delete) {
        return bannerDao.isDeleted(delete);
    }
}
