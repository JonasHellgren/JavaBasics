package domain_driven_design.domain.bill;

import domain_driven_design.domain.bill.entities.BillItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**Immutable, hence new Bill must be constructed when
  adding BillItem
 */

public record Bill(List<BillItem> billItems) {

    public static Bill empty() {
        return new Bill(Collections.emptyList());
    }

    public Bill withItem(BillItem billItem) {
        var newBillItems = new ArrayList<>(billItems());
        newBillItems.add(billItem);
        return new Bill(newBillItems);
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        sb.append(System.lineSeparator()).append("\t");
        billItems.forEach(bi -> sb.append(bi.toString()).append(", "));
        return sb.toString();
    }

}
