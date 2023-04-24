package com.example;

import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import com.example.cars.MainController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class MainContrTest {
    @Test
    public void ClientWarn() {
       MainController exception = new MainController();
        assertEquals("warning", exception.testProj("warning"));
    }

    @Test
    public void DriveWarn() {
        MainController exception = new MainController();
        assertEquals("warning", exception.testProj("warning"));
    }
    @Test
    public void ParkWarn() {
        MainController exception = new MainController();
        assertEquals("warning", exception.testProj("warning"));
    }


//    void menu(){
//        Model model = null;
//        ModelAndView modelAndView = new ModelAndView("menu");
//        String name = String.valueOf(MainController.menu(model));
//        Assertions.assertEquals(modelAndView, name);
//    }
}
