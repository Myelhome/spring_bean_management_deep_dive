package mmgeka.springbeanmanagement.deepdive.config;

import mmgeka.springbeanmanagement.deepdive.messenger.PrefixCaptureMessageMessenger;
import mmgeka.springbeanmanagement.deepdive.postprocessor.RandomStringUUIDAnnotationBeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessengerConfig {

    @Bean
    public RandomStringUUIDAnnotationBeanPostProcessor randomStringUUIDAnnotationBeanPostProcessor(){
        return new RandomStringUUIDAnnotationBeanPostProcessor();
    }

    @Bean
    public PrefixCaptureMessageMessenger prefixCaptureMessageMessenger(){
        var messenger = new PrefixCaptureMessageMessenger();
        messenger.setMessage("locked message");
        return messenger;
    }
}
