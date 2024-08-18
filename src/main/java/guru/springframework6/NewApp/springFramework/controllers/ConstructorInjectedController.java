package guru.springframework6.NewApp.springFramework.controllers;

import guru.springframework6.NewApp.springFramework.services.MyService;

public class ConstructorInjectedController {

   private final MyService myService;

    public ConstructorInjectedController(MyService myService) {
        this.myService = myService;
    }
    public String sayHello()
    {
        return myService.sayGreeting();
    }

}
