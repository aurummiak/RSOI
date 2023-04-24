package com.example.cars.repos;

import com.example.cars.domain.Offence;
import org.springframework.data.repository.CrudRepository;

public interface OffenceRepo extends CrudRepository<Offence, Integer> {
}
