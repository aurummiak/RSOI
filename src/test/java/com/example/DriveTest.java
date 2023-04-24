package com.example;

import com.example.cars.domain.Drive;
import com.example.cars.domain.Park;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DriveTest {
    @Test
    void testConstDrive() {
        int driveId = 1;
        int clientId = 1;
        int km = 1;
        int car_id = 1;

        Drive drive = new Drive(car_id,driveId,km,clientId);

        Assertions.assertEquals(car_id, drive.getCarId());
        Assertions.assertEquals(driveId, drive.getDriveId());
        Assertions.assertEquals(km, drive.getKm());
        Assertions.assertEquals(clientId, drive.getClientId());
    }


    @Test
    void testToStringPark() {
        int driveId = 20;
        int clientId = 1;
        int km = 4;
        int car_id = 5;

        Drive drive = new Drive(driveId, clientId, km, car_id);

        String expectedString = "Driveid = " + driveId +
                ", clientId=" + clientId +
                ", km = " + km +
                ", car_id = " + car_id + "\n";

        Assertions.assertEquals(expectedString, drive.toString());
    }

    @Test
    void testGetSetPark() {
        Drive drive = new Drive();

        int driveId = 20;
        int clientId = 1;
        int km = 4;
        int car_id = 5;

        drive.setDriveId(driveId);
        drive.setClientId(clientId);
        drive.setKm(km);
        drive.setCarId(car_id);

        Assertions.assertEquals(car_id, drive.getCarId());
        Assertions.assertEquals(driveId, drive.getDriveId());
        Assertions.assertEquals(km, drive.getKm());
        Assertions.assertEquals(clientId, drive.getClientId());


    }
}