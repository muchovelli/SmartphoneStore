package com.adam.mobileshop.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Brand {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="brand_name")
    private String name;

    @OneToMany
    @Column(name="smartphone_list")
    private List<Smartphone> smartphoneList;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
