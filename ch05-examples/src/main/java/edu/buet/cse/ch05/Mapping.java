package edu.buet.cse.ch05;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import edu.buet.cse.ch05.model.Dish;

public class Mapping {
  public static void main(String... args) {
    // example 1: map Dish to its name
    List<String> dishNameList = Dish.menu.stream().map(Dish::getName).collect(Collectors.toList());
    dishNameList.forEach(System.out::println);

    System.out.println();

    // example 2: map string to its length
    List<String> wordList = Arrays.asList("Hello", "World");
    List<Integer> wordLengthList =
        wordList.stream().map(String::length).collect(Collectors.toList());
    wordLengthList.forEach(System.out::println);

    System.out.println();

    // example 3: flatMap
    List<String> proverbList =
        Arrays.asList("A picture is worth a thousand words", "A barking dog seldom bites");
    proverbList.stream().flatMap(s -> Arrays.stream(s.split(" "))).filter(s -> s.length() > 2)
        .forEach(System.out::println);

    System.out.println();

    // example 4: flatMap
    List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5);
    List<Integer> numbers2 = Arrays.asList(6, 7, 8);

    List<int[]> tupleList =
        numbers1.stream().flatMap(i -> numbers2.stream().map(j -> new int[] {i, j}))
            .filter(a -> (a[0] + a[1]) % 3 == 0).collect(Collectors.toList());

    tupleList.forEach(a -> System.out.println(a[0] + ", " + a[1]));
  }
}
