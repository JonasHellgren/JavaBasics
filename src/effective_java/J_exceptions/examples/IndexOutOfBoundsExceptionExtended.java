package effective_java.J_exceptions.examples;

import lombok.Getter;

/**
 * Construct an extended IndexOutOfBoundsException.
 *

 */
@Getter
public class IndexOutOfBoundsExceptionExtended extends Exception {
    int lowerBound, upperBound, index;

    public IndexOutOfBoundsExceptionExtended(int lowerBound, int upperBound, int index) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        this.index = index;
    }

    @Override
    public String toString() {
       return this.getClass().getName()+": lb = "+lowerBound+" ,ub = "+upperBound+", idx = "+index;
    }

}

