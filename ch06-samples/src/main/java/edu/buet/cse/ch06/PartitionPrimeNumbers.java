package edu.buet.cse.ch06;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PartitionPrimeNumbers {
  public static void main(String... args) {
    System.out.println("Numbers partitioned in prime and non-prime: " + partitionPrimes(100));
  }

  private static Map<Boolean, List<Integer>> partitionPrimes(int n) {
    return IntStream.rangeClosed(2, n).boxed()
        .collect(Collectors.partitioningBy(PartitionPrimeNumbers::isPrime));
  }

  private static boolean isPrime(final int candidate) {
    return IntStream.rangeClosed(2, candidate - 1).boxed().limit((long) Math.floor(Math.sqrt(candidate)) - 1)
        .noneMatch(x -> candidate % x == 0);
  }
}
