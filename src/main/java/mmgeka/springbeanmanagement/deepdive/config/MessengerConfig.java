package mmgeka.springbeanmanagement.deepdive.config;

import mmgeka.springbeanmanagement.deepdive.contextlistener.PostProxyInvokerContextListener;
import mmgeka.springbeanmanagement.deepdive.factorypostprocessor.DeprecatedReplacementHandlerBeanFactoryPostProcessor;
import mmgeka.springbeanmanagement.deepdive.messenger.PrefixCaptureMessenger;
import mmgeka.springbeanmanagement.deepdive.messenger.SuffixCaptureMessenger;
import mmgeka.springbeanmanagement.deepdive.messenger.TestMessenger;
import mmgeka.springbeanmanagement.deepdive.messenger.entity.Suffix;
import mmgeka.springbeanmanagement.deepdive.postprocessor.ProfilingProxyAnnotationBeanPostProcessor;
import mmgeka.springbeanmanagement.deepdive.postprocessor.RandomStringUUIDAnnotationBeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

import java.util.UUID;

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
    public ProfilingProxyAnnotationBeanPostProcessor profilingProxyAnnotationBeanPostProcessor() {
        return new ProfilingProxyAnnotationBeanPostProcessor();
    }

    @Bean
    public DeprecatedReplacementHandlerBeanFactoryPostProcessor deprecatedReplacementHandlerBeanFactoryPostProcessor() {
        return new DeprecatedReplacementHandlerBeanFactoryPostProcessor();
    }

    @Bean
    public PrefixCaptureMessenger prefixCaptureMessenger() {
        var messenger = new PrefixCaptureMessenger();
        messenger.setMessage("hard-coded message");
        return messenger;
    }

    @Bean
    public SuffixCaptureMessenger suffixCaptureMessenger() {
        var messenger = new SuffixCaptureMessenger();
        messenger.setMessage("hard-coded message");
        return messenger;
    }

    @Bean
    public TestMessenger testMessenger() {
        return new TestMessenger();
    }

    @Bean
    @Scope(value = "prototype")
    public Suffix suffix() {
        return new Suffix(UUID.randomUUID().toString().substring(0, 8));
    }
}
