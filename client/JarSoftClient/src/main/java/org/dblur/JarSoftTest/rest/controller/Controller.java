package org.dblur.JarSoftTest.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class Controller {

    // BANNER

    @GetMapping("/")
    public String goToMainPage() {
        return "index";
    }

    @GetMapping("/banners/list")
    public String goBannerList() {
        return "bannerslist";
    }

    @GetMapping("/banner/page/{id}")
    public String goBannerPage() {
        return "bannerpage";
    }

    // CATEGORY

    @GetMapping("/categories/list")
    public String goCategoriesList() {
        return "categorieslist";
    }

    @GetMapping("/category/page/{id}")
    public String goCategoryPage() {
        return "categorypage";
    }

    @GetMapping("/add/banner")
    public String addBanner() {
        return "addbanner";
    }

    @GetMapping("/add/category")
    public String addCategory() {
        return "addcategory";
    }

    @GetMapping("edit/category/page/{id}")
    public String editCategoryPage() {
        return "editcategory";
    }

}
