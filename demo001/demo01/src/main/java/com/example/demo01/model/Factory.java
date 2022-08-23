package com.example.demo01.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Factory")
public class Factory {
    @Column(name="name", nullable = false)
    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

//    @OneToMany(mappedBy = "factory")
//    @OneToMany
//    private List<Car> cars;

//    public List<Car> getCars() {
//        return cars;
//    }
//
//    public void setCars(List<Car> cars) {
//        this.cars = cars;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Factory() {
    }
}
