package guru.springframework6.NewApp.springFramework.controllers;

import guru.springframework6.NewApp.springFramework.services.MyServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PropertyInjectedControllerTest {

    PropertyInjectedController propertyInjectedController;

    @BeforeEach
    void setUp() {
        propertyInjectedController= new PropertyInjectedController();
        propertyInjectedController.myService=new MyServiceImpl();

    }

    @Test
    void sayHello() {
        System.out.println(propertyInjectedController.sayHello());
    }
}