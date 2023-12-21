package com.project.appproduct;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AppProductApplicationTests {

    @Test
    void contextLoads() {
        AppProductApplication myClass = new AppProductApplication();
        Assertions.assertThat(myClass).isNotNull();
    }

}
