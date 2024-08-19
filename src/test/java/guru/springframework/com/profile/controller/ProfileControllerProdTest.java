package guru.springframework.com.profile.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProfileControllerProdTest {
    @Autowired
    ProfileController controller;

    @Test
    void dataSource() {
        System.out.println(controller.dataSource());
    }
}