package com.example.demo01.interfaces;

import com.example.demo01.model.SpecialCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialCarRepository extends JpaRepository<SpecialCar, Long> {

}
