package org.dblur.JarSoftTest.rest.model;

import lombok.Data;

import java.util.Set;

@Data
public class Category {

    private Long id;
    private String name;
    private String req_name;
    private boolean deleted;
    private Set<Banner> bannerSet;
}
