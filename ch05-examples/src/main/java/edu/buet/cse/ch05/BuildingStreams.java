package edu.buet.cse.ch05;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

public class BuildingStreams {
  public static void main(String... args) {
    Stream<String> stream = Stream.of("Java8", "lambdas", "in", "action");
    stream.map(String::toUpperCase).forEach(System.out::println);
    System.out.println();

    // empty stream
    Stream<String> emptyStream = Stream.empty();
    System.out.println("size of empty stream = " + emptyStream.count());
    System.out.println();

    // stream from array
    int[] numbers = {2, 3, 5, 7, 11, 13};
    int result = Arrays.stream(numbers).sum();
    System.out.println("sum is = " + result);
    System.out.println();

    // stream via iteration
    Stream.iterate(0, n -> n + 2).limit(10).forEach(System.out::println);
    System.out.println();

    // Fibonacci sequence with stream
    Stream.iterate(new int[] {0, 1}, t -> new int[] {t[1], t[0] + t[1]}).limit(10)
        .forEach(t -> System.out.println(t[0]));
    System.out.println();

    // random stream of double with Stream.generate
    Stream.generate(Math::random).limit(10).forEach(System.out::println);
    System.out.println();

    // random stream of integer
    Random randomGenerator = new Random();
    Stream.generate(() -> randomGenerator.nextInt(100)).limit(10).forEach(System.out::println);
    System.out.println();

    // read a file and figure out the number of distinct words
    try {
      URI resourceUri = BuildingStreams.class.getResource("/edu/buet/cse/ch05/data.txt").toURI();
      Path path = Paths.get(resourceUri);
      long distinctWordCount =
          Files.lines(path).flatMap(line -> Arrays.stream(line.split(" "))).distinct().count();
      System.out.println("number of distinct words = " + distinctWordCount);
    } catch (URISyntaxException | IOException ex) {
      System.err.println(ex);
    }
  }
}
