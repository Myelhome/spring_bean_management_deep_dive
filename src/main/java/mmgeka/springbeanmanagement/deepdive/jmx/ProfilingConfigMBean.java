package mmgeka.springbeanmanagement.deepdive.jmx;

import mmgeka.springbeanmanagement.deepdive.config.ProfilingConfig;
import org.springframework.jmx.export.annotation.*;
import org.springframework.stereotype.Component;

@Component
@ManagedResource(description = "Profiling config bean")
public class ProfilingConfigMBean {

    private final ProfilingConfig profilingConfig;

    public ProfilingConfigMBean(ProfilingConfig profilingConfig) {
        this.profilingConfig = profilingConfig;
    }

    @ManagedOperation(description = "Enable profiling")
    public void enableProfiling() {
        profilingConfig.setEnabled(true);
    }

    @ManagedOperation(description = "Disable profiling")
    public void disableProfiling() {
        profilingConfig.setEnabled(false);
    }

    @ManagedOperation(description = "Get profiling current state")
    public boolean isEnabled() {
        return profilingConfig.isEnabled();
    }

    @ManagedOperation(description = "Set custom profiling status")
    @ManagedOperationParameters({
            @ManagedOperationParameter(name = "profiling", description = "true/false")
    })
    public void setProfiling(boolean profiling) {
        profilingConfig.setEnabled(profiling);
    }
}
