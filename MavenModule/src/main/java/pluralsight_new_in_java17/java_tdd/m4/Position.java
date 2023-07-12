package pluralsight_new_in_java17.java_tdd.m4;

/**
 * Buying event
 */

public class Position {

    Stock stockName;
    int nofStocks;
    double averagePrice;

    public Position(Stock stockName, int nofStocks, double averagePrice) {
        this.stockName = stockName;
        this.nofStocks = nofStocks;
        this.averagePrice = averagePrice;
    }

    public Stock getStockName() {
        return stockName;
    }

    public int getNofStocks() {
        return nofStocks;
    }

    public double getAveragePx() {
        return averagePrice;
    }

    public double getValue() {
        return nofStocks * averagePrice;
    }

    public void setQuantity(int newQty) {
        this.nofStocks = newQty;
    }

    public void setAveragePx(double newAveragePx) {
        this.averagePrice = newAveragePx;
    }

    @Override
    public String toString() {
        return String.format("{ %s | Qty: %s | Px: %s | Value: %s}", stockName, nofStocks, averagePrice, nofStocks * averagePrice);
    }
}
