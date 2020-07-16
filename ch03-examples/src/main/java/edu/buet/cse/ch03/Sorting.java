package edu.buet.cse.ch03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import edu.buet.cse.ch03.model.Apple;

public class Sorting {
  public static void main(String... args) {
    List<Apple> inventory = new ArrayList<>();
    inventory.addAll(Arrays.asList(new Apple(80, "green"), new Apple(155, "green"),
        new Apple(120, "red"), new Apple(30, "green")));

    // sort and print the list
    inventory.sort((a1, a2) -> a1.getWeight().compareTo(a2.getWeight()));
    inventory.forEach(System.out::println);

    System.out.println();

    // make the inventory unordered again
    Collections.shuffle(inventory);

    // sort and print the list again
    inventory.sort(Comparator.comparing(Apple::getWeight));
    inventory.forEach(System.out::println);
  }
}
