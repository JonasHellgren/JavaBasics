package java_design_patterns.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CarRepo implements Iterable<String> {

    List<String> cars;

    public CarRepo() {
        cars = new ArrayList<>();
    }

    public void add(String car) {
        cars.add(car);
    }


    @Override
    public Iterator<String> iterator() {
        return new Iterator<>() {

            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < cars.size() && cars.get(currentIndex) != null;
            }

            @Override
            public String next() {
                return cars.get(currentIndex++);
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}
