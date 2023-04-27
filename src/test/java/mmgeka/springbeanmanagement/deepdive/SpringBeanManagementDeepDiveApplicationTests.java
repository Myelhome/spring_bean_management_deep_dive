package mmgeka.springbeanmanagement.deepdive;

import mmgeka.springbeanmanagement.deepdive.applicationcontext.PropertyFileApplicationContext;
import mmgeka.springbeanmanagement.deepdive.messenger.interfaces.Messenger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class SpringBeanManagementDeepDiveApplicationTests {

	@Autowired
	ApplicationContext context;

	@Test
	void contextLoads() throws InterruptedException {
		while (true) {
			context.getBean("prefixCaptureMessengerTestAdapter", Messenger.class).sendMessage("i'm ignored");
			context.getBean("testMessenger", Messenger.class).sendMessage("i'm ignored(test)");
			Thread.sleep(10_000);
		}
	}

}
