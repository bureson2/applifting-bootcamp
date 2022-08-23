package com.example.demo01.controler;

import com.example.demo01.model.Car;
import com.example.demo01.model.Factory;
import com.example.demo01.service.FactoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FactoryControler {
    @Autowired
    private FactoryService factoryService;

    @GetMapping("/factories")
    public List<Factory> getFactories(){
        return factoryService.getFactories();
    }

    @GetMapping("factorycars/{id}")
    public @ResponseBody List<Car> getCars(@PathVariable(value="id") Long id) {
        return factoryService.getCarsByFactory(id);
    }

    @PostMapping("/newfactory")
    public Optional<Factory> createFactory(@RequestBody Factory newFactory){
        return factoryService.createFactory(newFactory);
    }

    @PostMapping("/factory/{factoryid}/car/{carid}")
    public Optional<Factory> addCarToFactory(
            @PathVariable(value="factoryid") Long factoryid,
            @PathVariable(value="carid") Long carid) {
        return factoryService.addCarToFactory(factoryid, carid);
    }
}
