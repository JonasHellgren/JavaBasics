package domain_driven_design.service;

import domain_driven_design.domain.bill.Bill;
import domain_driven_design.domain.booking_recorder.BookingRecorder;
import domain_driven_design.domain.booking_recorder.entities.Booking;
import domain_driven_design.domain.menu.Menu;
import domain_driven_design.domain.menu.entities.Dish;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class RestaurantEditor {
    Menu menu;
    BookingRecorder bookings;

    public void addDishesToMenu(List<Dish> dishes) {
        dishes.forEach(d -> menu.addDish(d));
    }
    public void addBooking(Booking booking)  {
        bookings.addBooking(booking);
    }

    public void removeBooking(Integer id) {
        bookings.deleteBooking(id);
    }

    public void setBillOfBooking(Integer id, Bill bill) {
        bookings.getBooking(id).setBill(bill);
    }


}
