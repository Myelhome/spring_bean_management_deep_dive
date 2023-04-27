package mmgeka.springbeanmanagement.deepdive.config;

import mmgeka.springbeanmanagement.deepdive.contextlistener.PostProxyInvokerContextListener;
import mmgeka.springbeanmanagement.deepdive.messenger.PrefixCaptureMessageMessenger;
import mmgeka.springbeanmanagement.deepdive.postprocessor.ProfilingProxyAnnotationBeanPostProcessor;
import mmgeka.springbeanmanagement.deepdive.postprocessor.RandomStringUUIDAnnotationBeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessengerConfig {

    @Bean
    public PostProxyInvokerContextListener postProxyInvokerContextListener() {
        return new PostProxyInvokerContextListener();
    }

    @Bean
    public RandomStringUUIDAnnotationBeanPostProcessor randomStringUUIDAnnotationBeanPostProcessor() {
        return new RandomStringUUIDAnnotationBeanPostProcessor();
    }

    @Bean
    public ProfilingProxyAnnotationBeanPostProcessor profilingProxyAnnotationBeanPostProcessor() throws Exception {
        return new ProfilingProxyAnnotationBeanPostProcessor();
    }

    @Bean
    public PrefixCaptureMessageMessenger prefixCaptureMessageMessenger() {
        var messenger = new PrefixCaptureMessageMessenger();
        messenger.setMessage("hard-coded message");
        return messenger;
    }
}
