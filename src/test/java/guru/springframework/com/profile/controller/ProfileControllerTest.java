package guru.springframework.com.profile.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ProfileControllerTest {
@Autowired
    ProfileController profileController;

    @Test
    void dataSource() {
        System.out.println(profileController.dataSource());
    }
}