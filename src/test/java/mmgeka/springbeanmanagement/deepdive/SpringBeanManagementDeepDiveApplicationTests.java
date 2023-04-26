package mmgeka.springbeanmanagement.deepdive;

import mmgeka.springbeanmanagement.deepdive.config.MessengerConfig;
import mmgeka.springbeanmanagement.deepdive.messenger.Messenger;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
class SpringBeanManagementDeepDiveApplicationTests {

	@Test
	void contextLoads() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MessengerConfig.class);
		context.getBean(Messenger.class).sendMessage("i'm ignored");
	}

}
