package week4.practicum;

import java.util.List;

public class MessageViewer {

    public void view(List<Message> messages) {
        for(Message message : messages) {
            System.out.println("From: "+ message.getSender());
            System.out.println("Date/time: "+ message.getDatetime());
            System.out.println(message.getText());
            System.out.println("====================================================================");
        }
        System.out.println(messages.size()+" messages.");
    }

}