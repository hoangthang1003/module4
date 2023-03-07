package com.example.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="blog_type_name")
    private String nameBlogType;
    @OneToMany(mappedBy = "blogType")
    private Set<Blog> blogSet;
    public BlogType() {
    }
}
