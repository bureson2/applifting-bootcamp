package com.example.demo01.service;

import com.example.demo01.interfaces.CarRepository;
import com.example.demo01.interfaces.SpecialCarRepository;
import com.example.demo01.interfaces.WheelRepository;
import com.example.demo01.model.Car;
import com.example.demo01.model.Factory;
import com.example.demo01.model.SpecialCar;
import com.example.demo01.model.Wheel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private SpecialCarRepository specialCarRepository;

    @Autowired
    private WheelRepository wheelRepository;

    public List<Car> getCars(){
        return carRepository.findAll();
    }

    public List<SpecialCar> getSpecialCars(){
        return specialCarRepository.findAll();
    }

    public Optional<Car> createCar(Car newCar){
        carRepository.save(newCar);
        return carRepository.findById(newCar.getId());
    }

    public Optional<Car> addWheel(Long id){
        Optional<Car> car = carRepository.findById(id);
        Wheel newWheel = new Wheel();
        newWheel.setSize(10);
        wheelRepository.save(newWheel);
        car.get().getWheels().add(newWheel);
        carRepository.save(car.get());
        return car;
    }

}
