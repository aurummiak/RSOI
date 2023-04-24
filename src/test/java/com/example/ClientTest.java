package com.example;


import com.example.cars.Main;
import com.example.cars.domain.Clients;
import com.example.cars.repos.ClientRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
//@ContextConfiguration
//@RunWith(SpringRunner.class)
//@SpringBootTest

public class ClientTest {
    @InjectMocks
    private Clients clients;

    @Mock
    private ClientRepo clientRepo;

//    @Test
//    void addClient(){
//        Clients client = new Clients();
//        client.setName(null);
//        client.setPremium(true);
//        client.setExp(5);
//        when(clientRepo.findClientsById()).thenReturn(new ArrayList<>());
//        when(clientRepo.save(Mockito.any(Clients.class))).thenReturn(client);
//        boolean addClient = clientRepo.findClientsById().add(client);
//        assertEquals(client, addClient);
//
//    }


    @Test
    void testToStringClient() {
        int id = 15;
        String name = "Michael";
        int exp = 5;
        boolean prem = false;

        Clients clients = new Clients(id,name,exp,prem);

        String expectedString = "id = " + id +
                ", name = " + name +
                ", exp = " + exp +
                ", premium = " + prem + "\n";

        Assertions.assertEquals(expectedString, clients.toString());
    }


    @Test
    void testConstClient() {
        int id = 15;
        String name = "Michael";
        int exp = 5;
        boolean prem = false;

        Clients clients = new Clients(id,name,exp,prem);

        Assertions.assertEquals(id, clients.getId());
        Assertions.assertEquals(name, clients.getName());
        Assertions.assertEquals(exp, clients.getExp());
        Assertions.assertEquals(prem, clients.getPremium());
    }


    @Test
    void testGetSetClient() {
        Clients clients = new Clients();

        int id = 15;
        String name = "Michael";
        int exp = 5;
        boolean prem = false;

        clients.setId(id);
        clients.setName(name);
        clients.setPremium(prem);
        clients.setExp(exp);

        Assertions.assertEquals(id, clients.getId());
        Assertions.assertEquals(name, clients.getName());
        Assertions.assertEquals(exp, clients.getExp());
        Assertions.assertEquals(prem, clients.getPremium());

    }





}
