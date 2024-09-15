package apache.array;

import org.apache.commons.lang3.ArrayUtils;
import java.util.Arrays;
import java.util.List;

public class ArrayExamples {
    public static void main(String[] args) {
        // Adding elements to an array
        int[] array = {1, 2, 3};
        int[] newArray = ArrayUtils.add(array, 4);
        System.out.println("Adding element to array: " + Arrays.toString(newArray));

        int[] newArray2 = ArrayUtils.add(array, 1, 4);
        System.out.println("Adding element at specific index in array: " + Arrays.toString(newArray2));

        // Removing elements from an array
        int[] array2 = {1, 2, 3, 4};
        int[] removedArray = ArrayUtils.removeElement(array2, 2);
        System.out.println("Removing element from array: " + Arrays.toString(removedArray));

        int[] removedArray2 = ArrayUtils.removeAllOccurrences(array2, 2);
        System.out.println("Removing all occurrences of element from array: " + Arrays.toString(removedArray2));

        // Subarrays
        int[] array3 = {1, 2, 3, 4, 5};
        int[] subarray = ArrayUtils.subarray(array3, 0, 3);
        System.out.println("Subarray from start to specific index: " + Arrays.toString(subarray));

        int[] subarray2 = ArrayUtils.subarray(array3, 2, array3.length);
        System.out.println("Subarray from specific index to end: " + Arrays.toString(subarray2));

        // Array to list conversion
        int[] array4 = {1, 2, 3};
        List<Integer> list = List.of(ArrayUtils.toObject(array4));
        System.out.println("Array to list conversion: " + list);

        // List to array conversion
        List<Integer> list2 = Arrays.asList(1, 2, 3);
        int[] array5 = ArrayUtils.toPrimitive(list2.toArray(new Integer[0]));
        System.out.println("List to array conversion: " + Arrays.toString(array5));
    }
}
