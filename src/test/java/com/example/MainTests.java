package com.example;

import com.example.cars.Main;
import com.example.cars.MainController;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.junit.jupiter.api.Assertions.*;


//(classes = MainController.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

class MainTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void testApplicationStart() {
        Main.main(new String[] {});
        assertTrue(true); // если приложение запустилось без ошибок, то тест проходит успешно
    }

    // Пример теста для проверки наличия аннотации @SpringBootApplication
    @Test
    public void testSpringBootApplicationAnnotation() {
        assertNotNull(Main.class.getAnnotation(SpringBootApplication.class)); // проверяем, что аннотация @SpringBootApplication присутствует у класса приложения
    }

}
