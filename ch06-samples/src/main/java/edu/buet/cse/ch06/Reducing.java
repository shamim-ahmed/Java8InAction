package edu.buet.cse.ch06;

import java.util.Optional;
import java.util.stream.Collectors;

import edu.buet.cse.ch06.model.Dish;

public class Reducing {
  public static void main(String... args) {
    System.out.println("Total calories: " + calculateTotalCaloriesWithoutCollectors());
    System.out.println("Total calories: " + calculateTotalCalories());
    System.out.println("Total calories: " + calculateTotalCaloriesUsingMethodReference());
    System.out.println("Total calories: " + calculateTotalCaloriesUsingSum());
    System.out.println("Total calories: " + calculateTotalCaloriesUsingOptional());
  }

  private static int calculateTotalCaloriesWithoutCollectors() {
    return Dish.menu.stream().mapToInt(Dish::getCalories).reduce(0, (i, j) -> i + j);
  }

  private static int calculateTotalCalories() {
    return Dish.menu.stream()
        .collect(Collectors.reducing(0, Dish::getCalories, (Integer i, Integer j) -> i + j));
  }

  private static int calculateTotalCaloriesUsingMethodReference() {
    return Dish.menu.stream().collect(Collectors.reducing(0, Dish::getCalories, Integer::sum));
  }

  private static int calculateTotalCaloriesUsingSum() {
    return Dish.menu.stream().mapToInt(Dish::getCalories).sum();
  }

  private static Optional<Integer> calculateTotalCaloriesUsingOptional() {
    return Dish.menu.stream().map(Dish::getCalories).reduce(Integer::sum);
  }
}
