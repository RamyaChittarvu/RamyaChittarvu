package guru.springframework6.NewApp.springFramework.controllers;

import guru.springframework6.NewApp.springFramework.services.MyService;

public class SetterInjectedController {

    private MyService myService;

    public void setMyService(MyService myService) {
        this.myService = myService;
    }

    public String sayHello()
    {
        return myService.sayGreeting();
    }
}
