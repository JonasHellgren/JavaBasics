package domain_driven_design.domain.booking_recorder.entities;

import lombok.Builder;

@Builder
public record PayingGuest(String name,String phoneNumber) {
    public static PayingGuest ofName(String name) {
        return PayingGuest.builder().name(name).phoneNumber("").build();
    }

}
