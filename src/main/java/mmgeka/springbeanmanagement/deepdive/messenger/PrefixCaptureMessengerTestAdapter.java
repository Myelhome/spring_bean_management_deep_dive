package mmgeka.springbeanmanagement.deepdive.messenger;

import mmgeka.springbeanmanagement.deepdive.messenger.interfaces.Messenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PrefixCaptureMessengerTestAdapter extends TestMessenger {
    private Messenger delegate;

    @Autowired
    public void setDelegate(@Qualifier("prefixCaptureMessageMessenger") Messenger delegate) {
        this.delegate = delegate;
    }

    @Override
    public void sendMessage(String message) {
        delegate.sendMessage(message);
    }
}
