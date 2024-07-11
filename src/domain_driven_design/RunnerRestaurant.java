package domain_driven_design;

import domain_driven_design.domain.bill.Bill;
import domain_driven_design.domain.bill.entities.BillItem;
import domain_driven_design.domain.booking_recorder.BookingRecorder;
import domain_driven_design.domain.menu.Menu;
import domain_driven_design.persistence.factories.BookingDbFactory;
import domain_driven_design.persistence.factories.MenuDbFactory;
import domain_driven_design.service.RestaurantEditor;
import domain_driven_design.service.RestaurantInformer;

public class RunnerRestaurant {

    public static final int BOOOKING_ID = 1;

    public static void main(String[] args) {
        var menu = new Menu(MenuDbFactory.ofMcD());
        var bookings = new BookingRecorder(BookingDbFactory.ofSomeMcd());
        RestaurantEditor editor = new RestaurantEditor(menu, bookings);
        RestaurantInformer informer = new RestaurantInformer(menu, bookings);

        var billEmpty= Bill.empty();
        var bill1 = billEmpty.withItem(new BillItem(BOOOKING_ID,2));
        var bill2 = bill1.withItem(new BillItem(4,2));
        editor.setBillOfBooking(BOOOKING_ID, bill2);

        System.out.println("menu = " + informer.getMenu());
        System.out.println("bookings = " + informer.getBookings());

        System.out.println("recipe = " + informer.recipeOfBooking(BOOOKING_ID));


    }
}
