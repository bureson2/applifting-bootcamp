package com.example.demo01.controler;

import com.example.demo01.service.CarService;
import com.example.demo01.model.Car;
import com.example.demo01.model.SpecialCar;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
public class CarControler {

    @Autowired
    private CarService carService;

    @GetMapping("/cars")
    public List<Car> getCars() {
        return carService.getCars();
    }

    @GetMapping("/specialcars")
    public List<SpecialCar> getSpecialCars() {
        return carService.getSpecialCars();
    }

    @PostMapping("/newcar")
    public Optional<Car> createCar(@RequestBody Car newCar){
        return carService.createCar(newCar);
    }

    @GetMapping("/addwheel/{id}")
    public Optional<Car> addWheel(@PathVariable Long id){
        return carService.addWheel(id);

    }

}
