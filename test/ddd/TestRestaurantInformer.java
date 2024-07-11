package ddd;

import domain_driven_design.domain.bill.Bill;
import domain_driven_design.domain.bill.entities.BillItem;
import domain_driven_design.domain.booking_recorder.BookingRecorder;
import domain_driven_design.domain.menu.Menu;
import domain_driven_design.persistence.factories.BookingDbFactory;
import domain_driven_design.persistence.factories.MenuDbFactory;
import domain_driven_design.service.RestaurantEditor;
import domain_driven_design.service.RestaurantInformer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestRestaurantInformer {

    public static final int BOOOKING_ID = 1;
    RestaurantInformer informer;
    RestaurantEditor editor;

    @Before
    public void init() {
        var menu = new Menu(MenuDbFactory.ofMcD());
        var bookings = new BookingRecorder(BookingDbFactory.ofSomeMcd());
        editor = new RestaurantEditor(menu, bookings);
        informer = new RestaurantInformer(menu, bookings);
    }

    @Test
    public void whenSettingBill_thenCorrect() {
        var billEmpty = Bill.empty();
        var bill1 = billEmpty.withItem(new BillItem(BOOOKING_ID, 2));
        var bill2 = bill1.withItem(new BillItem(4, 2));
        editor.setBillOfBooking(BOOOKING_ID, bill2);

        Assert.assertEquals(2, informer.getBillFromBooking(
                BOOOKING_ID).orElseThrow().billItems().size());
        Assert.assertEquals(6, informer.getPriceTotal(
                informer.getBillFromBooking(BOOOKING_ID).orElseThrow()).doubleValue(), 0.1);

    }

}
