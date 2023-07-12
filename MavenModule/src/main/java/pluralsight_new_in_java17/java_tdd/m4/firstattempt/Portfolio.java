import java.util.ArrayList;
import java.util.List;

public class Portfolio {

    List<Stock> stocks = new ArrayList<>();

    public void printPortfolio() {
        stocks.forEach(System.out::println);
    }

    public void add(Stock symbol) {
        stocks.add(symbol);
    }

    public double totalValue() {

        // if stock in list,
        // then get that stock's value
        // add the new stock's value...

        if (stocks == null) {
            return 0;
        }
        return stocks.stream()
                .mapToDouble(Stock::totalValue)
                .sum();
    }
}
