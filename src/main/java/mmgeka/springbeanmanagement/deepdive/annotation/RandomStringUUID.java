package mmgeka.springbeanmanagement.deepdive.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface RandomStringUUID {
    int top() default 36;
}
