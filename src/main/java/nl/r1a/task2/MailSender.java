package nl.r1a.task2;

import com.mailjet.client.MailjetClient;
import com.mailjet.client.MailjetRequest;
import com.mailjet.client.MailjetResponse;
import com.mailjet.client.errors.MailjetException;
import com.mailjet.client.resource.Emailv31;
import lombok.Getter;
import org.json.JSONArray;
import org.json.JSONObject;

@Getter
public class MailSender {
    String api;
    String apiSecret;
    MailjetClient client;

    public MailSender(String api, String apiSecret, MailjetClient client) {
        this.api = api;
        this.apiSecret = apiSecret;
        this.client = client;
    }

    public void sendMail(MailInfo mailInfo) throws MailjetException {
        System.out.println("API: " + api);
        System.out.println("API_SECRET: " + apiSecret);
        System.out.println(
                "Sending mail to " + mailInfo.getClient().getName() +
                        " with code: " + mailInfo.getMailCode().getMailCode());
        MailjetRequest request;
        MailjetResponse response;
        request = new MailjetRequest(Emailv31.resource)
                .property(
                        Emailv31.MESSAGES,
                        new JSONArray().put(
                                new JSONObject()
                                        .put(Emailv31.Message.FROM,
                                                new JSONObject()
                                                        .put("Email",
                                                                mailInfo.getClient().getName())
                                                        .put("Name",
                                                                mailInfo.getClient().getName()))
                                        .put(Emailv31.Message.TO,
                                                new JSONArray().put(
                                                        new JSONObject()
                                                                .put("Email",
                                                                        mailInfo.getClient().getName())
                                                                .put("Name",
                                                                        mailInfo.getClient().getName())))
                                        .put(Emailv31.Message.SUBJECT,
                                                mailInfo.getMailCode().getMailCode())
                                        .put(Emailv31.Message.TEXTPART,
                                                mailInfo.getMailCode().getMailCode())
                                        .put(Emailv31.Message.CUSTOMID,
                                                "AppGettingStartedTest")));
        response = client.post(request);
        System.out.println(response.getStatus());
        System.out.println(response.getData());
    }
}
