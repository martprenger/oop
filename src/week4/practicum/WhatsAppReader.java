package week4.practicum;

import java.time.LocalDate;
import java.time.LocalTime;

public class WhatsAppReader {

    public WhatsAppMsg[] fetchMessages() {
        return new WhatsAppMsg[] {
                new WhatsAppMsg(new WhatsAppThread("06010420"), "Daily standup gaat niet door. Kat van de scrummaster heeft vlooien", LocalDate.now(), LocalTime.now()),
                new WhatsAppMsg(new WhatsAppThread("06995464"), "Het probleem met multithreading is opgelost. We gaan nu het decorator pattern implementeren.", LocalDate.now(), LocalTime.now())
        };
    }
}