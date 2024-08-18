package guru.springframework6.NewApp.springFramework.controllers;

import guru.springframework6.NewApp.springFramework.services.MyService;
import guru.springframework6.NewApp.springFramework.services.MyServiceImpl;
import org.springframework.stereotype.Controller;

@Controller
public class MyController {

    private final MyService greetingService;

    public MyController() {
        this.greetingService = new MyServiceImpl();
        }

    public String sayHello() {

        System.out.println("I'm in the controller!");

        return greetingService.sayGreeting();
    }
}
