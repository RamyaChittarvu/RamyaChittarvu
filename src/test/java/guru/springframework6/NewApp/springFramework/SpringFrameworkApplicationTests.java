package guru.springframework6.NewApp.springFramework;

import guru.springframework6.NewApp.springFramework.controllers.MyController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class SpringFrameworkApplicationTests {


	@Autowired
	ApplicationContext applicationContext;

	@Autowired
	MyController controller;

	@Test
	void testAutowireOfController()
	{
		System.out.println(controller.sayHello());
	}


	@Test
	void testController() {
		MyController myController = applicationContext.getBean(MyController.class);
		System.out.println(myController.sayHello());

	}
	@Test
	void contextLoads() {
	}

}
