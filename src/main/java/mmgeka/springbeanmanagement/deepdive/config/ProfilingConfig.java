package mmgeka.springbeanmanagement.deepdive.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
public class ProfilingConfig {
    private boolean enabled = true;
}
