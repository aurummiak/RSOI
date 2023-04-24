package com.example;

import ch.qos.logback.core.model.Model;
import com.example.cars.MainController;
import com.example.cars.domain.Clients;
import com.example.cars.domain.Offence;
import com.example.cars.repos.ClientRepo;
import com.example.cars.service.OffenceCount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import static org.mockito.Mockito.when;

public class OffenceCountTest {
    @Test
    void offenceCount() {
        String newDate = "2023-04-20";

        String res = OffenceCount.bringLineDate();

        Assertions.assertEquals(newDate, res);

    }

}
