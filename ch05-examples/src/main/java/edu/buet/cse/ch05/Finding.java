package edu.buet.cse.ch05;

import java.util.Optional;

import edu.buet.cse.ch05.model.Dish;

public class Finding {
  public static void main(String... args) {
    if (isVegetarianFriendlyMenu()) {
      System.out.println("Menu is Vegetarian friendly");
    }

    System.out.println(isHealthyMenu());
    System.out.println(isHealthyMenu2());

    Optional<Dish> veganDish = findVegetarianDish();
    veganDish.ifPresent(System.out::println);
  }

  private static boolean isVegetarianFriendlyMenu() {
    return Dish.menu.stream().anyMatch(Dish::isVegetarian);
  }

  private static boolean isHealthyMenu() {
    return Dish.menu.stream().allMatch(d -> d.getCalories() < 1000);
  }

  private static boolean isHealthyMenu2() {
    return Dish.menu.stream().noneMatch(d -> d.getCalories() >= 1000);
  }

  private static Optional<Dish> findVegetarianDish() {
    return Dish.menu.stream().filter(Dish::isVegetarian).findAny();
  }
}
