package edu.buet.cse.ch05;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;

import edu.buet.cse.ch05.model.Dish;

public class NumericStream {
  public static void main(String... args) {
    // example 1: print a numeric stream
    List<Integer> numbers = Arrays.asList(3, 4, 5, 1, 2);
    Arrays.stream(numbers.toArray()).forEach(System.out::println);

    System.out.println();

    // example 2: sum
    int sumOfCalories = Dish.menu.stream().map(Dish::getCalories).reduce(0, (a, b) -> a + b);
    System.out.println("sum of calories = " + sumOfCalories);

    System.out.println();

    // example 3: sum
    sumOfCalories = Dish.menu.stream().mapToInt(Dish::getCalories).sum();
    System.out.println("sum of calories = " + sumOfCalories);

    System.out.println();

    // example 4: max and OptionalInt
    OptionalInt maxCalories = Dish.menu.stream().mapToInt(Dish::getCalories).max();
    maxCalories.ifPresent(n -> System.out.println("maximum calories = " + n));    
  }
}
