package week4.practicum;

import java.time.LocalDateTime;

public final class StandardMessage implements Message{

    private final String sender;
    private final LocalDateTime datetime;
    private final String text;

    public StandardMessage(String sender, LocalDateTime datetime, String text) {
        this.sender = sender;
        this.datetime = datetime;
        this.text = text;
    }

    public String getSender() {
        return sender;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public String getText() {
        return text;
    }

}