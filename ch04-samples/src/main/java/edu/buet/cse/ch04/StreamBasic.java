package edu.buet.cse.ch04;

import java.util.List;
import java.util.stream.Collectors;

import edu.buet.cse.ch04.model.Dish;

public class StreamBasic {
  public static void main(String... args) {
    List<String> dishNames = getLowCalorieDishes(Dish.menu);

    dishNames.forEach(System.out::println);
  }

  private static List<String> getLowCalorieDishes(List<Dish> dishList) {
    return dishList.stream().filter(d -> d.getCalories() < 400).map(Dish::getName)
        .collect(Collectors.toList());
  }
}
