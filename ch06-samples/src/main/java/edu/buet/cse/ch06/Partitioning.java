package edu.buet.cse.ch06;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import edu.buet.cse.ch06.model.Dish;

public class Partitioning {
  public static void main(String... args) {
    System.out.println("Dishes partitioned by vegetarian: " + partitioningByVegetarian());
    System.out.println("Vegetarian dishes by type: " + vegetarianDishesByType());
  }

  private static Map<Boolean, List<Dish>> partitioningByVegetarian() {
    return Dish.menu.stream().collect(Collectors.partitioningBy(Dish::isVegetarian));
  }

  private static Map<Boolean, Map<Dish.Type, List<Dish>>> vegetarianDishesByType() {
    return Dish.menu.stream().collect(
        Collectors.partitioningBy(Dish::isVegetarian, Collectors.groupingBy(Dish::getType)));
  }
  
  
}
