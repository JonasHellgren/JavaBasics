package ddd;

import domain_driven_design.domain.bill.Bill;
import domain_driven_design.domain.bill.entities.BillItem;
import domain_driven_design.domain.booking_recorder.BookingRecorder;
import domain_driven_design.domain.booking_recorder.entities.Booking;
import domain_driven_design.domain.booking_recorder.entities.PayingGuest;
import domain_driven_design.domain.menu.Menu;
import domain_driven_design.domain.menu.entities.Dish;
import domain_driven_design.persistence.factories.BookingDbFactory;
import domain_driven_design.persistence.factories.MenuDbFactory;
import domain_driven_design.service.RestaurantEditor;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class TestRestaurantEditor {
    RestaurantEditor editor;
    Menu menu;
    BookingRecorder bookings;

    @Before
    public void init() {
        menu=new Menu(MenuDbFactory.ofMcD());
        bookings =new BookingRecorder(BookingDbFactory.ofSomeMcd());
        editor=new RestaurantEditor(menu, bookings);
    }

    @Test
    public void whenIds_thenCorrect() {

        var ids = menu.getDishIds();
        int size = menu.size();
        Assert.assertEquals(size, ids.size());
    }

    @Test
    public void whenAddingDish_thenCorrect() {
        int sizeOld=menu.size();
        Integer id=menu.largestId()+1;
        var dish= Dish.dessertOfIdNamePriceInEuros(id,"Fruit",1d);
        editor.addDishesToMenu(List.of(dish));
        Assert.assertEquals(sizeOld+1, menu.size());
    }

    @Test
    public void whenAddingBooking_thenCorrect() {
        int sizeOld= bookings.nBookings();
        Integer id= bookings.largestId()+1;
        var booking= Booking.ofIdAndGuest(id, PayingGuest.ofName("Alex"));
        editor.addBooking(booking);
        Assert.assertEquals(sizeOld+1, bookings.nBookings());
    }


    @Test
    public void whenRemoveBooking_thenCorrect() {
        int sizeOld= bookings.nBookings();
        bookings.deleteBooking(1);
        Assert.assertEquals(sizeOld-1, bookings.nBookings());
    }


        @Test
    public void whenSetBill_thenPresentBill() {
        var billEmpty= Bill.empty();
        var bill = billEmpty.withItem(new BillItem(1,1));
        bookings.setBillOfBooking(1, bill);
        var optBill = bookings.getBooking(1).getBill();
        Assert.assertTrue(optBill.isPresent());
        Assert.assertEquals(1,optBill.orElseThrow().billItems().get(0).dishId().intValue());
    }


}
