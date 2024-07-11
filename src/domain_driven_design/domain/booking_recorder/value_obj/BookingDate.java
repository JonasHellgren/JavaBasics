package domain_driven_design.domain.booking_recorder.value_obj;

import java.time.LocalDate;
import java.time.LocalTime;

public record BookingDate(LocalDate date, LocalTime time) {

    public static BookingDate now() {
        return new BookingDate(LocalDate.now(),LocalTime.now());
    }
}
