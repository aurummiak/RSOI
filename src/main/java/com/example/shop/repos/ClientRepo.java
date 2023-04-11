package com.example.shop.repos;

import com.example.shop.domain.Clients;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepo extends CrudRepository<Clients, Integer> {
}
