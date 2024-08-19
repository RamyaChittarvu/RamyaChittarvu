package guru.springframework.com.profile.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;
@ActiveProfiles("QA")
@SpringBootTest
class ProfileControllerQATest {

    @Autowired
    ProfileController controller;

    @Test
    void dataSource() {
        System.out.println(controller.dataSource());
    }
}