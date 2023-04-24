package com.example.cars.repos;

import com.example.cars.domain.Clients;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClientRepo extends CrudRepository<Clients, Integer> {

}
