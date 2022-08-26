package com.example.demo01.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Car")
public class Car {
    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
//    @JoinColumn(name="factory_id", nullable = false)
    private Factory factory;

    @OneToMany(cascade = CascadeType.ALL)
//    @Column(name="wheel_id", nullable = false)
    public List<Wheel> wheels;

    public List<Wheel> getWheels() {
        return wheels;
    }

    public void setWheels(List<Wheel> wheels) {
        this.wheels = wheels;
    }

    public Factory getFactory() {
        return factory;
    }

    public void setFactory(Factory factory) {
        this.factory = factory;
    }

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
}
