package com.vmware.question;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.vmware.question.app.OneApplication;

@SpringBootTest
@ContextConfiguration(classes = OneApplication.class)
class OneApplicationTests {

	@Test
	void contextLoads() {
	}

}
