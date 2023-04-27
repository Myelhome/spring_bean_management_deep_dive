package mmgeka.springbeanmanagement.deepdive.factorypostprocessor;

import mmgeka.springbeanmanagement.deepdive.annotation.DeprecatedReplacement;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class DeprecatedReplacementHandlerBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        for (var name : beanFactory.getBeanDefinitionNames()) {
            var beanDefinition = beanFactory.getBeanDefinition(name);
            var originalClassName = beanDefinition.getBeanClassName();

            try {
                Class<?> beanClass = null;
                if (originalClassName != null) {
                    beanClass = Class.forName(originalClassName);
                } else {
                    if (beanDefinition.getFactoryBeanName() == null || beanDefinition.getFactoryMethodName() == null)
                        continue;
                    try {
                        var factoryBeanName = beanDefinition.getFactoryBeanName();
                        var factoryName = beanFactory.getBeanDefinition(factoryBeanName).getBeanClassName();
                        var factoryClass = Class.forName(factoryName);
                        var factoryMethod = factoryClass.getMethod(beanDefinition.getFactoryMethodName());
                        beanClass = factoryMethod.getReturnType();
                    } catch (Exception ignore) {
                    }
                }

                if (beanClass != null) {
                    var annotation = beanClass.getAnnotation(DeprecatedReplacement.class);
                    if (annotation != null) {
                        beanDefinition.setBeanClassName(annotation.changeTo().getName());
                        beanDefinition.setFactoryBeanName(null);
                        beanDefinition.setFactoryMethodName(null);
                    }
                }

            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }
    }
}
