package com.example.cars.service;


import com.example.cars.domain.Drive;

public class SumKmCounting {
    public static int countKm(Drive drives) {
        int sumKm = 0;

            sumKm += drives.getKm();


        return sumKm;

    }


}
