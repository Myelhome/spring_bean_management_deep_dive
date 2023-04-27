package mmgeka.springbeanmanagement.deepdive.messenger;

import lombok.extern.slf4j.Slf4j;
import mmgeka.springbeanmanagement.deepdive.annotation.DeprecatedReplacement;
import mmgeka.springbeanmanagement.deepdive.annotation.ProfilingOverride;
import mmgeka.springbeanmanagement.deepdive.messenger.interfaces.Messenger;

@Slf4j
@ProfilingOverride
@DeprecatedReplacement(changeTo = PrefixCaptureMessengerTestAdapter.class)
public class TestMessenger implements Messenger {
    @Override
    public void sendMessage(String message) {
      log.info("test message send");
    }
}
