package apache.comparison;

import static org.apache.commons.lang3.compare.ComparableUtils.is;

public class TestComparison {

    public record City(String name, int population) implements Comparable<City> {
        @Override
        public int compareTo(City other) {
            return Integer.compare(this.population, other.population);
        }
    }

    public static void main(String[] args) {

        double a=1;
        double b=2;

        boolean isAGreaterThanB=is(a).greaterThan(b);
        boolean isAEqualToB=is(a).equalTo(b);
        boolean isALessThanB=is(a).lessThan(b);

        System.out.println("isAGreaterThanB: " + isAGreaterThanB +
                ", isAEqualToB: " + isAEqualToB +
                ", isALessThanB: " + isALessThanB);

        String x = "hello";
        String y = "world";
        boolean isXEqualToY = is(x).equalTo(y);
        System.out.println("isXEqualToY = " + isXEqualToY);

        City city1 = new City("New York", 8405837);
        City city2 = new City("Los Angeles", 3990456);

        boolean isNYGreaterThanLA = is(city1).greaterThan(city2);

        System.out.println("isNYGreaterThanLA = " + isNYGreaterThanLA);

    }
}
