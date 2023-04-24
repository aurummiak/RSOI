package com.example.cars.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "drives")
public class Drive {
    @Id
    @Column(name = "drive_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int driveId;

    @Column(name = "client_id")
    private int clientId;

    @Column(name = "km")
    private int km;

    @Column(name = "car_id")
    private int car_id;

    public Drive() {
    }

    public Drive(int driveId, int clientId, int km, int car_id) {
        this.driveId = driveId;
        this.clientId = clientId;
        this.km = km;
        this.car_id = car_id;
    }

    public int getCarId() {
        return car_id;
    }

    public void setCarId(int car_id) {
        this.car_id = car_id;
    }


    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public Drive(int clientId) {
        this.clientId = clientId;
    }

    public int getDriveId() {
        return driveId;
    }

    public void setDriveId(int driveId) {
        this.driveId = driveId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    @Override
    public String toString() {
        return "Driveid = " + driveId +
                ", clientId=" + clientId +
                ", km = " + km +
                ", car_id = " + car_id + "\n";
    }
}