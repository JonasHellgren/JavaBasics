package com.pluralsight.hashset;

import java.util.HashSet;

class Main {
    public static void main(String[] args) {
        HashSet<Integer> numbers = new HashSet<>();
        numbers.add(1);    numbers.add(2);    numbers.add(3);    numbers.add(4);
        System.out.println("HashSet1: " + numbers);

        HashSet<Integer> primeNumbers = new HashSet<>();
        primeNumbers.add(2);   primeNumbers.add(3);
        System.out.println("HashSet2: " + primeNumbers);

        boolean result = numbers.containsAll(primeNumbers); // Check if primeNumbers is a subset of numbers
        System.out.println("Is HashSet2 is subset of HashSet1? " + result);
    }
}