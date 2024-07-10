package domain_driven_design.restaurant_booking.domain.bill;

import domain_driven_design.restaurant_booking.domain.bill.entities.BillItem;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Bill {
    Integer id;
    @Getter  List<BillItem> billItems;

    public Bill(Integer id) {
        this.id = id;
        this.billItems=new ArrayList<>();
    }

    public void addBillItem(BillItem billItem) {
      this.billItems.add(billItem);
  }

}
