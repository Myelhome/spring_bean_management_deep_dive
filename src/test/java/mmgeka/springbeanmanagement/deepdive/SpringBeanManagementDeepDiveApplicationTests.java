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
		for (int i = 0; i < 3; i++) {
			context.getBean("prefixCaptureMessenger", Messenger.class).sendMessage("i'm ignored");
			context.getBean("testMessenger", Messenger.class).sendMessage("i'm ignored(test)");
			Thread.sleep(10_000);
		}
	}

	@Test
	void suffixCaptureMessenger(){
        for (int i = 0; i < 5; i++) context.getBean("suffixCaptureMessenger", Messenger.class).sendMessage("i'm ignored but new");
	}

	@Test
	void loadPropertiesContext(){
		ApplicationContext context = new PropertyFileApplicationContext("context.properties");
		context.getBean(Messenger.class).sendMessage("context");
	}

}
