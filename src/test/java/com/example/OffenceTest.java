package com.example;

import com.example.cars.domain.Drive;
import com.example.cars.domain.Offence;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class OffenceTest {
    @Test
    void testConstOffence() {
        int offenceId = 4;
        int client = 1;
        int fine = 5;
        LocalDate date = LocalDate.ofEpochDay(2010 - 03 - 03);

        Offence offence = new Offence(offenceId, client, fine, date);

        Assertions.assertEquals(offenceId, offence.getOffenceId());
        Assertions.assertEquals(client, offence.getClient());
        Assertions.assertEquals(fine, offence.getFine());
        Assertions.assertEquals(date, offence.getDate());
    }


}
