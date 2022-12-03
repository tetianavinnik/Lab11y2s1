package task2;

import com.mailjet.client.errors.MailjetException;
import com.mailjet.client.errors.MailjetSocketTimeoutException;

import java.util.ArrayList;
import java.util.List;

public class MailBox {
    private List<MailInfo> mailInfoList = new ArrayList<>();

    public void addMailInfo(MailInfo mailInfo) {
        mailInfoList.add(mailInfo);
    }

    public void sendAll() throws MailjetSocketTimeoutException, MailjetException {
        MailSender mailSender = new MailSender();
        for (MailInfo mailInfo:mailInfoList) {
            mailSender.sendMail(mailInfo);
        }
    }
}
