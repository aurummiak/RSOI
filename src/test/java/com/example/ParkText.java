package com.example;

import com.example.cars.domain.Clients;
import com.example.cars.domain.Park;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ParkText {

    @Test
    void testConstPark() {
        int car_id = 11;
        String car_name = "TESLA";
        int car_age = 2;
        int car_value = 400;
        int car_crash = 5;
        boolean car_alive = true;

        Park park = new Park(car_id,car_name,car_age,car_value,car_crash,car_alive);

        Assertions.assertEquals(car_id, park.getCarId());
        Assertions.assertEquals(car_name, park.getCarName());
        Assertions.assertEquals(car_age, park.getCarAge());
        Assertions.assertEquals(car_value, park.getCarValue());
        Assertions.assertEquals(car_crash, park.getCarHasCrash());
        Assertions.assertEquals(car_alive, park.isCarAlive());
    }

    @Test
    void testToStringPark() {
        int car_id = 11;
        String car_name = "TESLA";
        int car_age = 2;
        int car_value = 400;
        int car_crash = 5;
        boolean car_alive = true;

        Park park = new Park(car_id,car_name,car_age,car_value,car_crash,car_alive);

        String expectedString = "Park{" +
                "car_id=" + car_id +
                ", car_name='" + car_name + '\'' +
                ", car_age=" + car_age +
                ", car_value=" + car_value +
                ", car_hasCrash=" + car_crash +
                ", car_isAlive=" + car_alive +
                '}';

        Assertions.assertEquals(expectedString, park.toString());
    }


    @Test
    void testGetSetPark() {
        Park park = new Park();

        int car_id = 11;
        String car_name = "TESLA";
        int car_age = 2;
        int car_value = 400;
        int car_crash = 5;
        boolean car_alive = true;

        park.setCarId(car_id);
        park.setCarName(car_name);
        park.setCarAge(car_age);
        park.setCarValue(car_value);
        park.setCarHasCrash(car_crash);
        park.setCarAlive(car_alive);

        Assertions.assertEquals(car_id, park.getCarId());
        Assertions.assertEquals(car_name, park.getCarName());
        Assertions.assertEquals(car_age, park.getCarAge());
        Assertions.assertEquals(car_value, park.getCarValue());
        Assertions.assertEquals(car_crash, park.getCarHasCrash());
        Assertions.assertEquals(car_alive, park.isCarAlive());



    }

}
