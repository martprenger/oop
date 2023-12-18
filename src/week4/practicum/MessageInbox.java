package week4.practicum;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MessageInbox {

    private static MessageInbox instance;

    private MessageInbox() {};

    public static MessageInbox getInstance() {
        if (instance==null) { // non-thread safe maar dat is ok voor nu
            instance=new MessageInbox();
        }
        return instance;
    }
    public List<Message> getMessages() {
        List<Message> messages = new ArrayList<>();
        messages.add(new StandardMessage("joe", LocalDateTime.now(), "Ik ben er over 5 minuten" ));
        messages.add(new StandardMessage("Els", LocalDateTime.now(), "Ik heb joe gesproken. Hij staat achter ons idee." ));
        messages.add(new StandardMessage("ing", LocalDateTime.now(), "Uw tancode is 81824791" ));
        return messages;
    }

}