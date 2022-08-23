package com.example.demo01.service;

import com.example.demo01.interfaces.CarRepository;
import com.example.demo01.interfaces.FactoryRepository;
import com.example.demo01.model.Car;
import com.example.demo01.model.Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class FactoryService {

    @Autowired
    private FactoryRepository factoryRepository;

    @Autowired
    private CarRepository carRepository;

    public List<Factory> getFactories(){
        return factoryRepository.findAll();
    }


//    TODO
//    public List<Car> getCarsByFactory(Long id){
//        Optional<Factory> factory = factoryRepository.findById(id);
//        return factory.map(Factory::getCars).orElse(null);
//    }

    public Optional<Factory> createFactory(Factory newFactory){
        factoryRepository.save(newFactory);
        return factoryRepository.findById(newFactory.getId());
    }

    public Optional<Factory> addCarToFactory(Long factoryId, Long carId){
        Optional<Factory> factory = factoryRepository.findById(factoryId);
        Optional<Car> car = carRepository.findById(carId);
//        factory.get().getCars().add(car.get());
        car.get().setFactory(factory.get());
        carRepository.save(car.get());
        factoryRepository.save(factory.get());
        return factory;
    }

}
