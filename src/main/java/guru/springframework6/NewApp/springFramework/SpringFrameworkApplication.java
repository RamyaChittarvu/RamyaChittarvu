package guru.springframework6.NewApp.springFramework;

import guru.springframework6.NewApp.springFramework.controllers.MyController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringFrameworkApplication {

	public static void main(String[] args) {

		ApplicationContext ctx=SpringApplication.run(SpringFrameworkApplication.class, args);
		MyController myController=ctx.getBean(MyController.class);

		System.out.println("In Main Method");

		System.out.println(myController.sayHello());

	}

}
