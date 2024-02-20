package hellgren.car_state_updating.classes;

import lombok.Builder;

@Builder
public record CarParameters(double mass, double rollRes, double airRes) {
}
