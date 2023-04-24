package com.example.cars.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "park")

public class Park {
    @Id
    @Column(name = "car_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int car_id;

    @Column(name = "car_name")
    private String car_name;

    @Column(name = "car_age")
    private int car_age;

    @Column(name = "car_value")
    private int car_value;

    @Column(name = "car_crash")
    private int car_crash;


    @Column(name = "car_alive")
    private boolean car_alive;


    public Park() {

    }

    public Park(int car_id, String car_name, int car_age, int car_value, int car_crash, boolean car_alive) {
        this.car_id = car_id;
        this.car_name = car_name;
        this.car_age = car_age;
        this.car_value = car_value;
        this.car_crash = car_crash;
        this.car_alive = car_alive;
    }

    public int getCarId() {
        return car_id;
    }

    public void setCarId(int car_id) {
        this.car_id = car_id;
    }

    public String getCarName() {
        return car_name;
    }

    public void setCarName(String car_name) {
        this.car_name = car_name;
    }

    public int getCarAge() {
        return car_age;
    }

    public void setCarAge(int car_age) {
        this.car_age = car_age;
    }

    public int getCarValue() {
        return car_value;
    }

    public void setCarValue(int car_value) {
        this.car_value = car_value;
    }

    public int getCarHasCrash() {
        return car_crash;
    }

    public void setCarHasCrash(int car_crash) {
        this.car_crash = car_crash;
    }

    public boolean isCarAlive() {
        return car_alive;
    }

    public void setCarAlive(boolean car_alive) {
        this.car_alive = car_alive;
    }


    @Override
    public String toString() {
        return "Park{" +
                "car_id=" + car_id +
                ", car_name='" + car_name + '\'' +
                ", car_age=" + car_age +
                ", car_value=" + car_value +
                ", car_hasCrash=" + car_crash +
                ", car_isAlive=" + car_alive +
                '}';
    }
}
