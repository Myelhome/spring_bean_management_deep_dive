package mmgeka.springbeanmanagement.deepdive.messenger.entity;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component
public class SuffixPrototypeAccessor {

    @Lookup
    public Suffix getSuffix() {
        return null;
    }
}
