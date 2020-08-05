package edu.buet.cse.ch06;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import edu.buet.cse.ch06.model.Dish;

public class Grouping {
  enum CaloricLevel {
    DIET, NORMAL, FAT
  };

  public static void main(String... args) {
    System.out.println("Dishes grouped by type: " + groupDishesByType());
    System.out.println("Dish names grouped by type: " + groupDishNamesByType());
    System.out.println("Dish tags grouped by type: " + groupDishTagsByType());
    System.out.println("High calorie dishes grouped by type:" + groupHighCalorieDishesByType());
    System.out.println("Dishes grouped by calorie level:" + groupDishesByCaloricLevel());
    System.out
        .println("Dishes grouped by type and calorie level:" + groupDishesByTypeAndCaloricLevel());
    System.out.println("Dish count per type:" + countDishesPerType());
    System.out.println("Most caloric dish by type:" + mostCaloricDishByType());
    System.out.println(
        "Most caloric dish by type (without Optional):" + mostCaloricDishByTypeWithoutOptional());
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

  private static Map<CaloricLevel, List<Dish>> groupDishesByCaloricLevel() {
    return Dish.menu.stream().collect(Collectors.groupingBy((Dish dish) -> {
      if (dish.getCalories() <= 400) {
        return CaloricLevel.DIET;
      }

      if (dish.getCalories() <= 700) {
        return CaloricLevel.NORMAL;
      }

      return CaloricLevel.FAT;
    }));
  }

  private static Map<Dish.Type, Map<CaloricLevel, List<Dish>>> groupDishesByTypeAndCaloricLevel() {
    return Dish.menu.stream()
        .collect(Collectors.groupingBy(Dish::getType, Collectors.groupingBy((Dish dish) -> {
          if (dish.getCalories() <= 400) {
            return CaloricLevel.DIET;
          }

          if (dish.getCalories() <= 700) {
            return CaloricLevel.NORMAL;
          }

          return CaloricLevel.FAT;
        })));
  }

  private static Map<Dish.Type, Long> countDishesPerType() {
    return Dish.menu.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.counting()));
  }

  private static Map<Dish.Type, Optional<Dish>> mostCaloricDishByType() {
    return Dish.menu.stream().collect(Collectors.groupingBy(Dish::getType,
        Collectors.reducing((Dish d1, Dish d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2)));
  }

  private static Map<Dish.Type, Dish> mostCaloricDishByTypeWithoutOptional() {
    return Dish.menu.stream()
        .collect(Collectors.groupingBy(Dish::getType,
            Collectors.collectingAndThen(
                Collectors
                    .reducing((Dish d1, Dish d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2),
                Optional::get)));
  }
}
