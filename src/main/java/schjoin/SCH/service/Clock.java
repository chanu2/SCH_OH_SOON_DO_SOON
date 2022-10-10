package schjoin.SCH.service;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Clock {

    private LocalDateTime localDateTime;
    private LocalDate localDate;

    public Clock(LocalDateTime localDateTime, LocalDate localDate) {
        this.localDateTime = localDateTime;
        this.localDate = localDate;
    }
}
