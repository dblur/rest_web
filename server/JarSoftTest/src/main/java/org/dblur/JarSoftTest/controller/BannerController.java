package org.dblur.JarSoftTest.controller;

import org.dblur.JarSoftTest.model.Banner;
import org.dblur.JarSoftTest.service.bannerService.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BannerController {

    private final BannerService bannerService;

    @Autowired
    public BannerController(BannerService bannerService) {
        this.bannerService = bannerService;
    }

    @GetMapping( "/allBanners")
    public ResponseEntity<List<Banner>> getAllBanners() {
        List<Banner> bannerList = bannerService.getAll();
        return new ResponseEntity<>(bannerList, HttpStatus.OK);
    }

    @GetMapping("banners/{id}")
    public ResponseEntity<Banner> getBannerById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(bannerService.getById(id));
    }

    @PostMapping("/addBanner")
    @Transactional
    public ResponseEntity<Banner> addBanner(HttpEntity<Banner> httpEntity) {
        Banner banner = httpEntity.getBody();
        bannerService.add(banner);
        return new ResponseEntity<> (HttpStatus.OK);
    }

    @GetMapping("/deleteBanner/{id}")
    @Transactional
    public ResponseEntity<Banner> deleteBanner(@PathVariable Long id) {
        bannerService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
