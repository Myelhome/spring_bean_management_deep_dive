package mmgeka.springbeanmanagement.deepdive.messenger;

import jakarta.annotation.PostConstruct;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import mmgeka.springbeanmanagement.deepdive.annotation.PostProxy;
import mmgeka.springbeanmanagement.deepdive.messenger.entity.Suffix;
import mmgeka.springbeanmanagement.deepdive.messenger.entity.SuffixPrototypeAccessor;
import mmgeka.springbeanmanagement.deepdive.messenger.interfaces.HardCodedMessenger;
import mmgeka.springbeanmanagement.deepdive.messenger.interfaces.Messenger;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class SuffixCaptureMessenger implements Messenger, HardCodedMessenger {

    @Setter
    private String message;

    @Setter(onMethod = @__({@Autowired}))
    private SuffixPrototypeAccessor suffixAccessor;

    public SuffixCaptureMessenger() {
        log.info("constructor init, suffix {}", getSuffix());
    }

    @PostConstruct
    public void init() {
        log.info("post constructor init, suffix {}", getSuffix());
    }

    @Override
    public void sendMessage(String capturedMessage) {
        log.info("message \"{}\" captured, instead hard-coded message sent \"{}:{}\"", capturedMessage, message, getSuffix());
    }

    @Override
    public void sendHardCodedMessage() {
        log.info("hard-coded message sent \"{}:{}\"", message, getSuffix());
    }

    @Override
    @PostProxy
    public void onCreateSend() {
        log.info("messenger with message \"{}:{}\" is ready to use", message, getSuffix());
    }

    private Suffix getSuffix(){
        return suffixAccessor == null ? null : suffixAccessor.getSuffix();
    }
}
