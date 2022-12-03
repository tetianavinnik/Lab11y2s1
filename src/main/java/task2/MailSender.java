package task2;

import com.mailjet.client.errors.MailjetException;
import com.mailjet.client.errors.MailjetSocketTimeoutException;
import com.mailjet.client.MailjetClient;
import com.mailjet.client.MailjetRequest;
import com.mailjet.client.MailjetResponse;
import com.mailjet.client.ClientOptions;
import com.mailjet.client.resource.Emailv31;
import org.json.JSONArray;
import org.json.JSONObject;
import task2.MailInfo;

public class MailSender {
    public void sendMail(MailInfo mailInfo) throws MailjetException, MailjetSocketTimeoutException {
        MailjetClient client;
        MailjetRequest request;
        MailjetResponse response;
        client = new MailjetClient("2b851e5abc4c16740eb10936ca66e0b4", "94f99592339f1a71be33339e9b7bb12f", new ClientOptions("v3.1"));
        request = new MailjetRequest(Emailv31.resource)
                .property(Emailv31.MESSAGES, new JSONArray()
                        .put(new JSONObject()
                                .put(Emailv31.Message.FROM, new JSONObject()
                                        .put("Email", "tetiana.vinnik@ucu.edu.ua")
                                        .put("Name", "Tetiana"))
                                .put(Emailv31.Message.TO, new JSONArray()
                                        .put(new JSONObject()
                                                .put("Email", mailInfo.getClient().getEmail())
                                                .put("Name", mailInfo.getClient().getName())))
                                .put(Emailv31.Message.SUBJECT, "Greetings from us!")
                                .put(Emailv31.Message.TEXTPART, String.format("Hello %s", mailInfo.getClient().getName()))
                                .put(Emailv31.Message.HTMLPART, String.format("<h3>%s</h3>", mailInfo.generate()))
                                .put(Emailv31.Message.CUSTOMID, "AppGettingStartedTest")));
    }
}
