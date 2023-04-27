package mmgeka.springbeanmanagement.deepdive.contextlistener;

import mmgeka.springbeanmanagement.deepdive.annotation.PostProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.util.ReflectionUtils;

public class PostProxyInvokerContextListener implements ApplicationListener<ContextRefreshedEvent> {

    private ConfigurableListableBeanFactory factory;

    @Autowired
    public void setFactory(ConfigurableListableBeanFactory factory) {
        this.factory = factory;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        var context = event.getApplicationContext();
        for (var name : context.getBeanDefinitionNames()) {
            var beanDefinition = factory.getBeanDefinition(name);
            var originalClassName = beanDefinition.getBeanClassName();

            try {
                Class<?> originalClass = null;
                if (originalClassName != null) {
                    originalClass = Class.forName(originalClassName);
                } else {
                    if (beanDefinition.getFactoryBeanName() == null || beanDefinition.getFactoryMethodName() == null) continue;
                    try {
                        originalClass = context.getBean(beanDefinition.getFactoryBeanName()).getClass()
                                .getMethod(beanDefinition.getFactoryMethodName())
                                .getReturnType();
                    }catch (Exception ignore) {
                    }
                }

                if(originalClass != null) {
                    for (var method : originalClass.getDeclaredMethods()) {
                        if (method.isAnnotationPresent(PostProxy.class)) {
                            var bean = context.getBean(name);
                            var currentMethod = bean.getClass().getMethod(method.getName(), method.getParameterTypes());
                            ReflectionUtils.invokeMethod(currentMethod, bean);
                        }
                    }
                }

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }


    }
}
