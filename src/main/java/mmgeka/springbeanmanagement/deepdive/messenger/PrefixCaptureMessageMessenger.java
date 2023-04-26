package mmgeka.springbeanmanagement.deepdive.messenger;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import mmgeka.springbeanmanagement.deepdive.annotation.Profiling;
import mmgeka.springbeanmanagement.deepdive.annotation.RandomStringUUID;

@Slf4j
@Profiling
public class PrefixCaptureMessageMessenger implements Messenger {

    private String message;

    @RandomStringUUID(top = 8)
    private String prefix;

    public void setMessage(String message) {
        this.message = message;
    }

    public PrefixCaptureMessageMessenger() {
        log.info("constructor init, prefix {}", prefix);
    }

    @PostConstruct
    public void init(){
        log.info("post constructor init, prefix {}", prefix);
    }

    @Override
    public void sendMessage(String capturedMessage) {
        log.info("message \"{}\" captured, instead hard-coded message sent \"{}:{}\"", capturedMessage, prefix, message);
    }
}
