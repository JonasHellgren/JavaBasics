package domain_driven_design.domain.booking_recorder.entities;

import domain_driven_design.domain.bill.Bill;
import domain_driven_design.domain.booking_recorder.value_obj.BookingDate;
import lombok.*;

import java.util.Optional;

@Builder
@Getter
@ToString
public class Booking {
    @NonNull Integer id;
    @NonNull PayingGuest guest;
    @Builder.Default
    BookingDate bookingDate= BookingDate.now();
    @Builder.Default Integer numberOfGuests=1;
    @Setter
    Bill bill;

    public static Booking ofIdAndGuest(Integer id, PayingGuest guest) {
        return Booking.builder()
                .id(id).guest(guest)
                .build();
    }

    public Optional<Bill> getBill() {
        return bill==null?Optional.empty():Optional.of(bill);
    }
}
