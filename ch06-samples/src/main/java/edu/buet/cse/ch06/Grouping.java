package edu.buet.cse.ch06;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import edu.buet.cse.ch06.model.Dish;

public class Grouping {
  public static void main(String... args) {
    System.out.println("Dishes grouped by type: " + groupDishesByType());
    System.out.println("Dish names grouped by type: " + groupDishNamesByType());
    System.out.println("Dish tags grouped by type: " + groupDishTagsByType());
    System.out.println("High calorie dishes grouped by type:" + groupHighCalorieDishesByType());
  }

  private static Map<Dish.Type, List<Dish>> groupDishesByType() {
    return Dish.menu.stream().collect(Collectors.groupingBy(Dish::getType));
  }

  private static Map<Dish.Type, List<String>> groupDishNamesByType() {
    return Dish.menu.stream().collect(Collectors.groupingBy(Dish::getType,
        Collectors.mapping(Dish::getName, Collectors.toList())));
  }

  private static Map<Dish.Type, Set<String>> groupDishTagsByType() {
    Function<Dish, Stream<String>> func = dish -> {
      List<String> tagList = Dish.dishTags.get(dish.getName());
      return tagList != null ? tagList.stream() : Stream.empty();
    };

    return Dish.menu.stream().collect(
        Collectors.groupingBy(Dish::getType, Collectors.flatMapping(func, Collectors.toSet())));
  }

  private static Map<Dish.Type, List<Dish>> groupHighCalorieDishesByType() {
    return Dish.menu.stream().collect(Collectors.groupingBy(Dish::getType,
        Collectors.filtering(d -> d.getCalories() > 500, Collectors.toList())));
  }
}
