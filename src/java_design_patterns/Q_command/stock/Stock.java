package java_design_patterns.Q_command.stock;

import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
public class Stock {
    private final String name;
    private final Long quantity;


    public void buy() {
        System.out.println("Bought stock:"+this);
    }

    public void sell() {
        System.out.println("Sold stock:"+this);
    }
}
