package mmgeka.springbeanmanagement.deepdive.messenger;

import lombok.extern.slf4j.Slf4j;
import mmgeka.springbeanmanagement.deepdive.annotation.RandomStringUUID;

@Slf4j
public class PrefixCaptureMessageMessenger implements Messenger {

    private String message;

    @RandomStringUUID(top = 8)
    private String prefix;

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public void sendMessage(String capturedMessage) {
        log.info("message \"{}\" captured, instead hard-coded message sent \"{}:{}\"", capturedMessage, prefix, message);
    }
}
