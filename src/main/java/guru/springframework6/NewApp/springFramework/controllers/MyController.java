package guru.springframework6.NewApp.springFramework.controllers;

import org.springframework.stereotype.Controller;

@Controller
public class MyController {
    public String sayHello() {

        System.out.println("I'm in the controller!");

        return "Hello Everyone!!!";
    }
}
