package org.dblur.JarSoftTest.rest.controller;

import org.dblur.JarSoftTest.rest.model.Banner;
import org.dblur.JarSoftTest.rest.service.bannerService.BannerServiceRestImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BannerController {

    private final BannerServiceRestImpl bannerService;

    @Autowired
    public BannerController(BannerServiceRestImpl bannerService) {
        this.bannerService = bannerService;
    }

    @GetMapping("/banners")
    public List<Banner> getAllBanners() {
        return bannerService.getAll();
    }

    @GetMapping("/banner/{id}")
    public Banner getBannerById(@PathVariable Long id) {
        return bannerService.getById(id);
    }

    @GetMapping("/delete/banner/{id}")
    public String deleteBanner(@PathVariable Long id) {
        bannerService.delete(id);
        return "success";
    }

    @PostMapping("/add/banner")
    public String addBanner(@RequestBody Banner banner) {
        bannerService.add(banner);
        return "success";
    }

}
