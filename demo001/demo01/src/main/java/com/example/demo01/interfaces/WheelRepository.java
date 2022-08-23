package com.example.demo01.interfaces;

import com.example.demo01.model.Wheel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WheelRepository extends JpaRepository<Wheel, Long> {
}
