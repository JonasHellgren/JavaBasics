package pluralsight_new_in_java17.java_tdd.m4;

import java.util.HashMap;
import java.util.Map;

public class Portfolio {

    private final Map<String, Position> positions;

    public Portfolio() {
        this.positions = new HashMap<>();
    }

    public Map<String, Position> getAllPositions() {
        return positions;
    }

    public void add(Position position) {
        String symbol = position.getStock().symbol();

        // If the position already exists, update it
        if (positions.containsKey(symbol)) {
            Position existingPosition = positions.get(symbol);
            int newQuantity = existingPosition.getQty() + position.getQty();
            double newAveragePx = (existingPosition.getQty() * existingPosition.getAveragePx()
                    + position.getQty() * position.getAveragePx()) / newQuantity;

            existingPosition.setQuantity(newQuantity);
            existingPosition.setAveragePx(newAveragePx);

        } else {
            positions.put(symbol, position);
        }
    }

    public Position getPosition(String symbol) {
        return positions.get(symbol);
    }

    public double getTotalValue() {
        return positions.values().stream()
                .mapToDouble(Position::getValue)
                .sum();
    }

    public void print() {
        positions.values()
                .forEach(System.out::println);

        System.out.println("===================================");
        System.out.println(getTotalValue());
    }
}
