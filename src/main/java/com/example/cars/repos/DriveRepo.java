package com.example.cars.repos;

import com.example.cars.domain.Drive;
import org.springframework.data.repository.CrudRepository;

public interface DriveRepo extends CrudRepository<Drive, Integer> {
}
