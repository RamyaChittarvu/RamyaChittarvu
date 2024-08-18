package guru.springframework6.NewApp.springFramework.controllers;

import guru.springframework6.NewApp.springFramework.services.MyService;

public class PropertyInjectedController {

    MyService myService;

    public  String sayHello()
    {
        return myService.sayGreeting();
    }
}
