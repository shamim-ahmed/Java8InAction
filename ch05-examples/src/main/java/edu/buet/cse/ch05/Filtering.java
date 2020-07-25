package edu.buet.cse.ch05;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import edu.buet.cse.ch05.model.Dish;

public class Filtering {
  public static void main(String... args) {
    // example 1: find vegetarian dishes
    List<Dish> vegetarianDishList =
        Dish.menu.stream().filter(Dish::isVegetarian).collect(Collectors.toList());
    vegetarianDishList.forEach(System.out::println);

    System.out.println();

    // example 2: find distinct even numbers
    List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
    numbers.stream().filter(i -> i % 2 == 0).distinct().forEach(System.out::println);

    System.out.println();

    // example 3: truncating a stream
    List<Dish> highCalorieDishList =
        Dish.menu.stream().filter(d -> d.getCalories() > 300).limit(3).collect(Collectors.toList());
    highCalorieDishList.forEach(System.out::println);

    System.out.println();

    // example 4: skipping elements
    Dish.menu.stream().filter(d -> d.getCalories() > 300).skip(2).forEach(System.out::println);
    
    System.out.println();
  }
}
