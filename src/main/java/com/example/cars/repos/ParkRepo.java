package com.example.cars.repos;


import com.example.cars.domain.Park;
import org.springframework.data.repository.CrudRepository;

public interface ParkRepo extends CrudRepository<Park, Integer> {
}
