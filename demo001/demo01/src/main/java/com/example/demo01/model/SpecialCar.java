package com.example.demo01.model;

import com.example.demo01.model.Car;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
public class SpecialCar extends Car {

    String specialAttribute;

    public String getSpecialAttribute() {
        return specialAttribute;
    }

    public void setSpecialAttribute(String specialAttribute) {
        this.specialAttribute = specialAttribute;
    }
}
