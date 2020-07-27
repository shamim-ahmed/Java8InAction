package edu.buet.cse.ch05;

import java.util.Arrays;
import java.util.List;

import edu.buet.cse.ch05.model.Dish;

public class Reducing {
  public static void main(String... args) {
    // example 1
    List<Integer> numbers = Arrays.asList(3, 4, 5, 1, 2);
    int sum1 = numbers.stream().reduce(0, (a, b) -> a + b);
    System.out.println("The sum is: " + sum1);

    System.out.println();

    // example 2
    int sum2 = numbers.stream().reduce(0, Integer::sum);
    System.out.println("The sum is: " + sum2);

    System.out.println();

    // example 3
    int max1 = numbers.stream().reduce(Integer.MIN_VALUE, (a, b) -> a >= b ? a : b);
    System.out.println("The max value is: " + max1);

    System.out.println();


    // example 4
    int max2 = numbers.stream().reduce(Integer.MIN_VALUE, Integer::max);
    System.out.println("The max value is: " + max2);

    System.out.println();

    // example 5
    int calories1 = Dish.menu.stream().map(Dish::getCalories).reduce(0, Integer::sum);
    System.out.println("Sum of calories: " + calories1);

    System.out.println();

    // example 6
    int calories2 = Dish.menu.stream().mapToInt(Dish::getCalories).sum();
    System.out.println("Sum of calories: " + calories2);

    System.out.println();
  }
}
