package mmgeka.springbeanmanagement.deepdive;

import mmgeka.springbeanmanagement.deepdive.config.MessengerConfig;
import mmgeka.springbeanmanagement.deepdive.messenger.Messenger;
import mmgeka.springbeanmanagement.deepdive.postprocessor.ProfilingProxyAnnotationBeanPostProcessor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
class SpringBeanManagementDeepDiveApplicationTests {

	@Autowired
	ApplicationContext context;

	@Test
	void contextLoads() throws InterruptedException {
		while (true) {
			context.getBean(Messenger.class).sendMessage("i'm ignored");
			Thread.sleep(10_000);
		}
	}

}
