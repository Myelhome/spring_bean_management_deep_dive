package mmgeka.springbeanmanagement.deepdive.scope;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.util.HashMap;
import java.util.Map;

public class E2PrototypeScopeConfigurer implements Scope {
    private final Map<String, Pair<Object, Long>> map = new HashMap<>();

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        map.putIfAbsent(name, new Pair<>(objectFactory.getObject(), 0L));

        if(map.get(name).value() > 1) map.put(name, new Pair<>(objectFactory.getObject(), 0L));

        var beanRepeats = map.get(name);
        map.put(name, new Pair<>(beanRepeats.key(), beanRepeats.value() + 1));

        return map.get(name).key();
    }

    @Override
    public Object remove(String name) {
        return null;
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {

    }

    @Override
    public Object resolveContextualObject(String key) {
        return null;
    }

    @Override
    public String getConversationId() {
        return null;
    }

    private record Pair<K, V>(K key, V value) {
    }
}