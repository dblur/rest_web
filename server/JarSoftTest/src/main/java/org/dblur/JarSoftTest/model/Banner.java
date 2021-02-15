package org.dblur.JarSoftTest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "Banner")
public class Banner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private double price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(name = "content")
    private String content;

    @Column(name = "deleted")
    private boolean deleted;

//    @OneToMany(mappedBy = "banner", fetch = FetchType.EAGER)
//    private transient Set<Request> requestSet;
}
