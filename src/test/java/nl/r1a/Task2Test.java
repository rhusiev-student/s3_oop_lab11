package nl.r1a;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.mailjet.client.ClientOptions;
import com.mailjet.client.MailjetClient;

import nl.r1a.task2.Client;
import nl.r1a.task2.MailBox;
import nl.r1a.task2.MailInfo;
import nl.r1a.task2.MailSender;
import nl.r1a.task2.mailcodes.WorkMail;

public class Task2Test {
    @Test
    public void testCreation() {
        String api = "api";
        String apiSecret = "apiSecret";
        Client client = new Client("Name", 42, "MALE");
        MailInfo mailInfo = new MailInfo(client, new WorkMail());
        MailjetClient mailjetClient = new MailjetClient(api, apiSecret);
        ClientOptions options =
            ClientOptions.builder().apiKey(api).apiSecretKey(apiSecret).build();
        MailSender mailSender = new MailSender(api, apiSecret, mailjetClient);
        MailBox mailBox = new MailBox();
        mailBox.addMailInfo(mailInfo);
        MailInfo mailInfo1 = new MailInfo(client, new WorkMail());
        mailBox.addMailInfo(mailInfo1);

        assertEquals(client.getId(), 0);
        assertEquals(client.getName(), "Name");
        assertEquals(client.getAge(), 42);

        assertEquals(mailInfo.getClient().getId(), 0);
        assertEquals(mailInfo.getClient().getName(), "Name");
        assertEquals(mailInfo.getClient().getAge(), 42);
        assertEquals(mailInfo.getMailCode().getMailCode(), "Work work work...");
        
        assertEquals(mailSender.getApi(), api);
        assertEquals(mailSender.getApiSecret(), apiSecret);
        assertEquals(mailSender.getClient(), mailjetClient);

        assertEquals(mailBox.getInfos().size(), 2);
        assertEquals(mailBox.getInfos().get(0).getClient().getId(), 0);
    }
}
