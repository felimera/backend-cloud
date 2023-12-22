package com.project.configservice;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ConfigServiceApplicationTests {

	@Test
	void contextLoads() {
		ConfigServiceApplication myClass = new ConfigServiceApplication();
		Assertions.assertThat(myClass).isNotNull();
	}

}
