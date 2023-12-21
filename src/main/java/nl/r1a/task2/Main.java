package nl.r1a.task2;

import nl.r1a.task2.mailcodes.WorkMail;
import nl.r1a.task2.mailcodes.BirthdayMail;

import com.mailjet.client.MailjetClient;
import com.mailjet.client.ClientOptions;

public class Main {
    public static void main(String[] args) {
        Client client = new Client("husiev.pn@ucu.edu.ua", 42, "MALE");
        MailInfo mailInfo = new MailInfo(client, new WorkMail());
        String api = System.getenv("API");
        String apiSecret = System.getenv("API_SECRET");
        MailjetClient mailjetClient;
        ClientOptions options =
            ClientOptions.builder().apiKey(api).apiSecretKey(apiSecret).build();
        mailjetClient = new MailjetClient(options);
        MailSender mailSender = new MailSender(api, apiSecret, mailjetClient);
        try {
            mailSender.sendMail(mailInfo);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        MailBox mailBox = new MailBox();
        mailBox.addMailInfo(mailInfo);
        MailInfo mailInfo1 = new MailInfo(client, new BirthdayMail());
        mailBox.addMailInfo(mailInfo1);
        mailBox.sendAll(mailSender);
    }
}
