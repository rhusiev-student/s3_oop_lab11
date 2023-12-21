package nl.r1a.task2;

import lombok.Getter;
import nl.r1a.task2.mailcodes.MailCode;

@Getter
public class MailInfo {
    private Client client;
    private MailCode mailCode;

    public MailInfo(Client client, MailCode mailCode) {
        this.client = client;
        this.mailCode = mailCode;
    }
}
