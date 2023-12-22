package com.project.appshopping;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AppShoppingApplicationTests {

	@Test
	void contextLoads() {
		AppShoppingApplication myClass = new AppShoppingApplication();
		Assertions.assertThat(myClass).isNotNull();
	}

}
