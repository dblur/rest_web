package org.dblur.JarSoftTest.rest.model;

import lombok.Data;

import java.util.Set;

@Data
public class Banner {

    private Long id;
    private String name;
    private double price;
    private Category category;
    private String content;
    private boolean deleted;

//    private transient Set<Request> requestSet;
}
