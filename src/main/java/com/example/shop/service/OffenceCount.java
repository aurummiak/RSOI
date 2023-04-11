package com.example.shop.service;

import com.example.shop.domain.Offence;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;

@Service
public class OffenceCount {
    public static float count(ArrayList<Offence> offences) {
        float sum = 0;
        int amountOfMarks = 0;

        for (Offence offence : offences) {
            if (offence.getDate().isAfter(LocalDate.now().minusMonths(3))) {
                sum += offence.getFine();
                amountOfMarks++;
            } else {
                for (Offence element : offences) {
                    if (element.getDate().isAfter(LocalDate.now().minusYears(1))) {
                        sum += element.getFine();
                        amountOfMarks++;
                    }
                }
            }
        }
        return sum / amountOfMarks;
    }
}
