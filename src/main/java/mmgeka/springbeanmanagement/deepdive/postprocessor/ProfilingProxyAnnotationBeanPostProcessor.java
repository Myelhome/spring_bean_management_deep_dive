package mmgeka.springbeanmanagement.deepdive.postprocessor;

import lombok.extern.slf4j.Slf4j;
import mmgeka.springbeanmanagement.deepdive.annotation.ProfilingOverride;
import mmgeka.springbeanmanagement.deepdive.config.ProfilingConfig;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class ProfilingProxyAnnotationBeanPostProcessor implements BeanPostProcessor {
    private final Map<String, Class<?>> map = new HashMap<>();
    private ProfilingConfig profiling;

    @Autowired
    public void setProfiling(ProfilingConfig profiling) {
        this.profiling = profiling;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean.getClass().isAnnotationPresent(ProfilingOverride.class)) map.put(beanName, bean.getClass());

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        var clazz = map.get(beanName);
        if (clazz != null) {
            return Proxy.newProxyInstance(bean.getClass().getClassLoader(), bean.getClass().getInterfaces(), (proxy, method, args) -> {
                if (profiling.isEnabled()) {
                    var before = System.nanoTime();
                    var ret = method.invoke(bean, args);
                    var after = System.nanoTime();
                    log.info("profiling:{} -> {}, cost: {}", bean.getClass().getName(), method, after - before);
                    return ret;
                }
                return method.invoke(bean, args);
            });
        }

        return bean;
    }
}
