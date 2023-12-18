package week4.practicum;

import java.time.LocalDate;
import java.time.LocalTime;

public class WhatsAppMsg {

    private WhatsAppThread whatsAppThread;
    private String content;
    private LocalDate date;
    private LocalTime time;

    public WhatsAppMsg(WhatsAppThread whatsAppThread, String content, LocalDate date, LocalTime time) {
        this.whatsAppThread = whatsAppThread;
        this.content = content;
        this.date = date;
        this.time = time;
    }

    public WhatsAppThread getWhatsAppThread() {
        return whatsAppThread;
    }

    public String getContent() {
        return content;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }
}