package mmgeka.springbeanmanagement.deepdive.postprocessor;

import mmgeka.springbeanmanagement.deepdive.annotation.RandomStringUUID;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.ReflectionUtils;

import java.util.UUID;

public class RandomStringUUIDAnnotationBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        for (var field : bean.getClass().getDeclaredFields()) {
            var annotation = field.getAnnotation(RandomStringUUID.class);
            if (annotation != null) {
                var top = annotation.top();
                var randomUUID = UUID.randomUUID().toString().substring(0, Math.min(36, top));
                field.setAccessible(true);
                ReflectionUtils.setField(field, bean, randomUUID);
            }
        }

        return bean;
    }
}
