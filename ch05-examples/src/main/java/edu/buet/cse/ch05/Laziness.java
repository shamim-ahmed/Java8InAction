package edu.buet.cse.ch05;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Laziness {
  public static void main(String... args) {
    // generate a list of numbers from 1 to 8
    List<Integer> valueList = Stream.iterate(1, n -> n + 1).limit(8).collect(Collectors.toList());

    // filter first two even numbers and form a list of their squares
    List<Integer> resultList = valueList.stream().filter(n -> {
      System.out.println("filtering " + n);
      return n % 2 == 0;
    }).map(n -> {
      System.out.println("mapping " + n);
      return n * n;
    }).limit(2).collect(Collectors.toList());;

    resultList.forEach(System.out::println);
  }
}
