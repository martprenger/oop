package week4.practicum;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        MessageViewer messageViewer = new MessageViewer();
        List<Message> messages = MessageInbox.getInstance().getMessages();

        WhatsAppReader whatsAppReader = new WhatsAppReader();
        for(WhatsAppMsg whatsAppMsg : whatsAppReader.fetchMessages()) {
            messages.add(new WhatsAppAdapter(whatsAppMsg));
        }

        messageViewer.view(messages);
    }
}
