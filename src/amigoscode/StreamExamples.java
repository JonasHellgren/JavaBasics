package amigoscode;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExamples {

    @Data
    @AllArgsConstructor
    static  class NumAndSquared {
        int num;
        int sqNum;
    }

    List<Integer> numberList= Arrays.asList(1,2,3,4);

    @Test
    public void replaceFor() {
        List<NumAndSquared> numAndSquaredList=numberList.stream()
                .map(num -> new NumAndSquared(num, num * num))
                .collect(Collectors.toList());

        Assert.assertEquals(4,numAndSquaredList.size());
        Assert.assertEquals(4,numAndSquaredList.get(1).getSqNum());
    }


    @Test
    public void anyMatch() {
        boolean anyMatch=numberList.stream().anyMatch(num -> num==2);
        Assert.assertTrue(anyMatch);
    }
}