package edu.buet.cse.ch04;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamVsCollection {
  public static void main(String... args) {
    List<String> nameList = Arrays.asList("Java8", "Lambdas", "In", "Action");
    Stream<String> nameStream = nameList.stream();

    // terminal operation
    nameStream.forEach(System.out::println);

    // uncommenting the following line will throw an exception
    // nameStream.map(s -> s.toUpperCase()).forEach(System.out::println);
  }
}
