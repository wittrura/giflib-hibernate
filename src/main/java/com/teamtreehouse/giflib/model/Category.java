package com.teamtreehouse.giflib.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String colorCode;

    // without mappedBy, a new table is created like in many to many
    // with mappedBy, category id will be column in gifs table
    @OneToMany(mappedBy = "category")
    private List<Gif> gifs = new ArrayList<>();

    public Category(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColorCode() {
        return colorCode;
    }

    public void setColorCode(String colorCode) {
        this.colorCode = colorCode;
    }

    public List<Gif> getGifs() {
        return gifs;
    }

}
