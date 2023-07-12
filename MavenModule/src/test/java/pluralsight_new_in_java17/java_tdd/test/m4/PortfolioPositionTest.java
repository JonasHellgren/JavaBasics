package pluralsight_new_in_java17.java_tdd.test.m4;


import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import pluralsight_new_in_java17.java_tdd.m4.Portfolio;
import pluralsight_new_in_java17.java_tdd.m4.Position;
import pluralsight_new_in_java17.java_tdd.m4.Stock;

import static org.junit.Assert.assertEquals;

public class PortfolioPositionTest {

    @Test
    public void emptyPortfolio_zeroPositions() {
        var portfolio = new Portfolio();
        assertEquals(0, portfolio.getAllPositions().size());
    }

    @Test
    public void portfolioWithOnePosition_ReturnsThatPosition() {
        var portfolio = new Portfolio();

        String symbol = "MSFT";

        portfolio.add(position(symbol, 10, 260));
        Assertions.assertEquals(1, portfolio.getAllPositions().size());

        Assertions.assertEquals(10, portfolio.getPosition(symbol).getNofStocks());
        Assertions.assertEquals(260, portfolio.getPosition(symbol).getAveragePx());
        Assertions.assertEquals(2600, portfolio.getPosition(symbol).getValue());
    }

    @Test
    public void portfolioWithTwoDifferentPositions_ReturnsThosePositions() {
        var portfolio = new Portfolio();

        String microsoft = "MSFT";
        String apple = "AAPL";

        portfolio.add(position(microsoft, 10, 260));
        portfolio.add(position(apple, 2, 150));

        Assertions.assertEquals(2, portfolio.getAllPositions().size());

        // msft
        var microsoftPosition = portfolio.getPosition(microsoft);
        Assertions.assertEquals(10, microsoftPosition.getNofStocks());
        Assertions.assertEquals(260, microsoftPosition.getAveragePx());
        Assertions.assertEquals(2600, microsoftPosition.getValue());

        // aapl
        var applePosition = portfolio.getPosition(apple);
        Assertions.assertEquals(2, applePosition.getNofStocks());
        Assertions.assertEquals(150, applePosition.getAveragePx());
        Assertions.assertEquals(300, applePosition.getValue());
    }

    static Position position(String symbol, int qty, double px) {
        return new Position(new Stock(symbol), qty, px);
    }

    @Test
    public void portfolioWithSameStock_ReturnsOnePosition() {
        var portfolio = new Portfolio();

        String microsoft = "MSFT";

        portfolio.add(position(microsoft, 10, 260));
        portfolio.add(position(microsoft, 5, 200));

        Assertions.assertEquals(1, portfolio.getAllPositions().size());
    }

    @Test
    public void portfolioWithSameStock_ReturnsCorrectQty() {
        var portfolio = new Portfolio();

        String microsoft = "MSFT";

        portfolio.add(position(microsoft, 10, 260));
        portfolio.add(position(microsoft, 1, 200));

        Assertions.assertEquals(11, portfolio.getPosition(microsoft).getNofStocks());
    }

    @Test
    public void portfolioWithSameStock_ReturnsCorrectAveragePrice() {
        var portfolio = new Portfolio();

        String microsoft = "MSFT";
        portfolio.add(position(microsoft, 1, 240));
        portfolio.add(position(microsoft, 1, 220));

        Assertions.assertEquals(230, portfolio.getPosition("MSFT").getAveragePx());
    }

    @Test
    public void portfolioWithSameStock_ReturnsCorrectPositionValue() {
        var portfolio = new Portfolio();

        String microsoft = "MSFT";
        portfolio.add(position(microsoft, 2, 240));
        portfolio.add(position(microsoft, 1, 220));

        double expected = 2 * 240 + 220;
        Assertions.assertEquals(expected, portfolio.getPosition(microsoft).getValue());
    }

    @Test
    public void complexPortfolio_ReturnsCorrectTotalValue() {
        var portfolio = new Portfolio();

        portfolio.add(position("MSFT", 1, 260));
        portfolio.add(position("MSFT", 2, 250));

        portfolio.add(position("AAPL", 5, 90));
        portfolio.add(position("AAPL", 10, 80));

        portfolio.add(position("ORCL", 100, 80));

        Assertions.assertEquals(3, portfolio.getAllPositions().size());
        Assertions.assertEquals(10010, portfolio.getTotalValue());
    }
}
