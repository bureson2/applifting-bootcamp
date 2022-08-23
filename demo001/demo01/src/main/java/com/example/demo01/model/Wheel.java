package com.example.demo01.model;

import javax.persistence.*;

@Entity
public class Wheel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @Column(name="radius", nullable = false)
    private double radius;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getSize() {
        return radius;
    }

    public void setSize(double radius) {
        this.radius = radius;
    }
}
