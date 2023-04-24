package com.example.cars.service;

import com.example.cars.domain.Offence;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;

@Service
public class OffenceCount {
    public static float count(ArrayList<Offence> offences) {
        int amountOfOffences = 0;

        for (Offence offence : offences) {
            if (offence.getDate().isAfter(LocalDate.now().minusMonths(3))) {
//                sum += offence.getFine();
                amountOfOffences++;
            } else {
                for (Offence element : offences) {
                    if (element.getDate().isAfter(LocalDate.now().minusYears(1))) {
//                        sum += element.getFine();
                       int auf = amountOfOffences / 2;
                    }
                }
            }
        }
        return amountOfOffences; // sum/amount
    }

    public static String bringLineDate(){
        String time = "2023-04-20";
        if (time.equals(LocalDate.now())){
            time = "2001-01-01";
        } else {
            time = "2023-04-20";
        }
        return time;

    }
}
