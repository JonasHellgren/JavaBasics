package domain_driven_design.service;

import domain_driven_design.domain.bill.Bill;
import domain_driven_design.domain.bill.entities.BillItem;
import domain_driven_design.domain.booking_recorder.BookingRecorder;
import domain_driven_design.domain.booking_recorder.entities.Booking;
import domain_driven_design.domain.menu.Menu;
import domain_driven_design.domain.menu.entities.Dish;
import domain_driven_design.domain.shared.value_obj.Price;
import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.List;
import java.util.Optional;

@Getter
@AllArgsConstructor
public class RestaurantInformer {
    Menu menu;
    BookingRecorder bookings;
    
    public List<Integer> getDishIds() {
       return menu.getDishIds();
    }
    public Dish getDish(Integer id) {
        return menu.getDish(id);
    }
    public List<Integer> getBookingIds() {
        return bookings.getBookingIds();
    }
    public Booking getBooking(Integer id) {
        return bookings.getBooking(id);
    }
    public Optional<Bill> getBillFromBooking(Integer id) {
        return bookings.getBooking(id).getBill();
    }

    public List<Booking> bookingsFromGuest(String name) {
        return bookings.getBookingIds().stream()
                .map(bookings::getBooking)
                .filter(booking -> booking.getGuest().name().equals(name))
                .toList();
    }

    public String recipeOfBooking(Integer id) {
        var booking=getBooking(id);
        if (booking.getBill().isEmpty()) {
            return "no bill defined";
        }
        return getRecipe(booking);
    }

    private String getRecipe(Booking booking) {
        var bill= booking.getBill().orElseThrow();
        StringBuilder sb=new StringBuilder();
        sb.append(System.lineSeparator());
        bill.billItems().stream()
                .map(item -> lineForBillItem(item))
                .forEach(sb::append);
        sb.append(System.lineSeparator());
        sb.append("priceTotal=").append(getPriceTotal(bill));
        return sb.toString();
    }

    public Double getPriceTotal(Bill bill) {
        return bill.billItems().stream()
                .mapToDouble(item -> priceOfBillItem(item))
                .sum();
    }

    private String lineForBillItem(BillItem item) {
        var dish = getDish(item.dishId());
        return "Dish=" + dish.getName() +
                ", price=" + getPriceOfDish(dish).amount() +
                ", quant.=" + item.quantity() + System.lineSeparator();
    }

    private double priceOfBillItem(BillItem item) {
        return item.quantity() *
                getPriceOfDish(getDish(item.dishId())).amount();
    }

    private static Price getPriceOfDish(Dish dish) {
        return dish.getPrice();
    }


}
