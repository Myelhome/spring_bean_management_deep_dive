package mmgeka.springbeanmanagement.deepdive.applicationcontext;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;

@Slf4j
public class PropertyFileApplicationContext extends GenericApplicationContext {
    public PropertyFileApplicationContext(String fileName) {
        PropertiesBeanDefinitionReader reader = new PropertiesBeanDefinitionReader(this);
        int i = reader.loadBeanDefinitions(fileName);
        log.info("Loaded {} beans", i);
        refresh();
    }
}
