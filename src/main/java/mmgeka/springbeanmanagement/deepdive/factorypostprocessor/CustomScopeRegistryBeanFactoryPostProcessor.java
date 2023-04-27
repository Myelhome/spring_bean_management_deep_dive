package mmgeka.springbeanmanagement.deepdive.factorypostprocessor;

import mmgeka.springbeanmanagement.deepdive.scope.E2PrototypeScopeConfigurer;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class CustomScopeRegistryBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        beanFactory.registerScope("e2prototype", new E2PrototypeScopeConfigurer());
    }
}
