package nl.r1a.task2;

import java.util.ArrayList;
import java.util.List;

public class MailBox {
    private List<MailInfo> infos;

    public MailBox(List<MailInfo> infos) { this.infos = infos; }

    public MailBox() { this.infos = new ArrayList<>(); }

    public void addMailInfo(MailInfo info) { infos.add(info); }

    public void sendAll(MailSender sender) {
        for (MailInfo info : infos) {
            try {
                sender.sendMail(info);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
