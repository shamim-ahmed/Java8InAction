package edu.buet.cse.ch03;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import edu.buet.cse.ch03.model.Apple;

public class Lambdas {
  public static void main(String... args) {
    List<Apple> inventory =
        Arrays.asList(new Apple(80, "green"), new Apple(155, "green"), new Apple(120, "red"));

    // filter green apples
    List<Apple> greenApples =
        inventory.stream().filter(a -> a.getColor().equals("green")).collect(Collectors.toList());
    greenApples.forEach(System.out::println);

    System.out.println();

    // define a comparator using lambda
    Comparator<Apple> appleComparator = (a1, a2) -> Integer.compare(a1.getWeight(), a2.getWeight());

    // sort the inventory
    inventory.sort(appleComparator);
    inventory.forEach(System.out::println);
  }
}
