package edu.buet.cse.ch06;

import java.util.Comparator;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

import edu.buet.cse.ch06.model.Dish;

public class Summarizing {
  public static void main(String... args) {
    System.out.println("Number of dishes: " + howManyDishes());
    System.out.println("Most caloric dish: " + findMostCaloricDish());
    System.out.println("Most caloric dish: " + findMostCaloricDishUsingComparator());
  }

  private static Long howManyDishes() {
    return Dish.menu.stream().collect(Collectors.counting());
  }

  private static Dish findMostCaloricDish() {
    return Dish.menu.stream().collect(
        Collectors.reducing((Dish d1, Dish d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2))
        .get();
  }

  private static Dish findMostCaloricDishUsingComparator() {
    Comparator<Dish> dishComparator =
        (Dish d1, Dish d2) -> Integer.compare(d1.getCalories(), d2.getCalories());
    BinaryOperator<Dish> binaryOp = BinaryOperator.maxBy(dishComparator);
    return Dish.menu.stream().reduce(binaryOp).get();
  }
}
