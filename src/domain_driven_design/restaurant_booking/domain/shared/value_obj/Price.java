package domain_driven_design.restaurant_booking.domain.shared.value_obj;

public record Price(double amount, String currency) {

    public static Price ofEuro(double amount) {
        return new Price(amount, "Euro");
    }
}
