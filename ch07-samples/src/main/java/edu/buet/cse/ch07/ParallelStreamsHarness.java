package edu.buet.cse.ch07;

import java.util.function.Function;

public class ParallelStreamsHarness {
  public static void main(String... args) {
    System.out.println(
        "Iterative sum: " + measurePerf(ParallelStreams::iterativeSum, 10_000_000L) + " ms");
    System.out.println(
        "Sequential sum: " + measurePerf(ParallelStreams::sequentialSum, 10_000_000L) + " ms");
    System.out.println(
        "Sequential sum: " + measurePerf(ParallelStreams::sequentialSum2, 10_000_000L) + " ms");
    System.out
        .println("Parallel sum: " + measurePerf(ParallelStreams::parallelSum, 10_000_000L) + " ms");
    System.out
        .println("Ranged sum: " + measurePerf(ParallelStreams::rangedSum, 10_000_000L) + " ms");
    System.out.println("Parallel ranged sum: "
        + measurePerf(ParallelStreams::parallelRangedSum, 10_000_000L) + " ms");
    System.out.println("Side effect sum (sequential): "
        + measurePerf(ParallelStreams::sideEffectSum, 10_000_000L) + " ms");
    System.out.println("Side effect sum (parallel): "
        + measurePerf(ParallelStreams::sideEffectSumParallel, 10_000_000L) + " ms");
  }

  private static <T, R> long measurePerf(Function<T, R> func, T input) {
    long minExecutionTime = Long.MAX_VALUE;

    for (int i = 0; i < 10; i++) {
      long start = System.nanoTime();
      R result = func.apply(input);
      long end = System.nanoTime();
      long executionTime = (end - start) / 1_000_000L;

      if (executionTime < minExecutionTime) {
        minExecutionTime = executionTime;
      }
    }

    return minExecutionTime;
  }
}
