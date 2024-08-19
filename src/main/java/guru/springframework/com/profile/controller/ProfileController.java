package guru.springframework.com.profile.controller;

import guru.springframework.com.profile.service.DataSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class ProfileController {

   private final DataSourceService dataSourceService;

    public ProfileController(@Qualifier("ProfileService") DataSourceService dataSourceService) {
        this.dataSourceService = dataSourceService;
    }


    public String dataSource()
    {
        System.out.println("Environment Controller");
        return dataSourceService.printDataSource();
    }
}
