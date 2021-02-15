package org.dblur.JarSoftTest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "Category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "req_name")
    private String req_name;

    @Column(name = "deleted")
    private boolean deleted;

    @JsonIgnore
    @OneToMany(mappedBy = "category")
    private List<Banner> banners;

}
