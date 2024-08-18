package guru.springframework6.NewApp.springFramework.controllers;

import guru.springframework6.NewApp.springFramework.services.MyServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SetterInjectedControllerTest {

    SetterInjectedController setterInjectedController;

    @BeforeEach
    void setUp() {
        setterInjectedController = new SetterInjectedController();
      setterInjectedController.setMyService(new MyServiceImpl());

    }

    @Test
    void sayHello() {
        System.out.println(setterInjectedController.sayHello());
    }
}