package mmgeka.springbeanmanagement.deepdive.messenger;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import mmgeka.springbeanmanagement.deepdive.annotation.PostProxy;
import mmgeka.springbeanmanagement.deepdive.annotation.ProfilingOverride;
import mmgeka.springbeanmanagement.deepdive.annotation.RandomStringUUID;
import mmgeka.springbeanmanagement.deepdive.messenger.interfaces.HardCodedMessenger;
import mmgeka.springbeanmanagement.deepdive.messenger.interfaces.Messenger;

@Slf4j
@ProfilingOverride
public class PrefixCaptureMessageMessenger implements Messenger, HardCodedMessenger {

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
    public void init() {
        log.info("post constructor init, prefix {}", prefix);
    }

    @Override
    public void sendMessage(String capturedMessage) {
        log.info("message \"{}\" captured, instead hard-coded message sent \"{}:{}\"", capturedMessage, prefix, message);
    }

    @Override
    public void sendHardCodedMessage() {
        log.info("hard-coded message sent \"{}:{}\"", prefix, message);
    }

    @Override
    @PostProxy
    public void onCreateSend() {
        log.info("messenger with message \"{}:{}\" is ready to use", prefix, message);
    }
}
