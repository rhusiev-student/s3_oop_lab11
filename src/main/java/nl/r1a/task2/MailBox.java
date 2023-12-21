package nl.r1a.task2;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

public class MailBox {
    @Getter
    private List<MailInfo> infos;

    public MailBox(List<MailInfo> infos) {
        this.infos = infos;
    }

    public MailBox() {
        this.infos = new ArrayList<>();
    }

    public void addMailInfo(MailInfo info) {
        infos.add(info);
    }

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
