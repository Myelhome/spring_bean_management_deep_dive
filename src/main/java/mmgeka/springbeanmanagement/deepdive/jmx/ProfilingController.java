package mmgeka.springbeanmanagement.deepdive.jmx;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfilingController implements ProfilingControllerMBean {
    private boolean enabled;
}
