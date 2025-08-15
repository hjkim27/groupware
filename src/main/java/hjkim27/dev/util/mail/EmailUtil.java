package hjkim27.dev.util.mail;

import hjkim27.dev.lib.exception.EmailSendException;
import hjkim27.dev.lib.util.mail.EmailSendUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EmailUtil {

    public static boolean sendFindInformation(
            String user,
            String password,
            String host,
            int port,
            String title,
            String body,
            String senderEmail
    ) {
        try {
            EmailSendUtil.sendMultipartMailwithSSL(
                    user, password, host, port,
                    null, null, null,
                    title, body, null, senderEmail);
        } catch (EmailSendException e) {
            log.error(e.getMessage());
            return false;
        }
        return true;
    }
}
