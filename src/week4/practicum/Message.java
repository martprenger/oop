package week4.practicum;

import java.time.LocalDateTime;

public interface Message {

    String getSender();
    LocalDateTime getDatetime();
    String getText();

}