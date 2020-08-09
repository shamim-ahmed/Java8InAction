package edu.buet.cse.ch07;

import java.util.stream.LongStream;

public class ParallelStreams {
  public static long iterativeSum(long n) {
    long result = 0L;

    for (long i = 1; i <= n; i++) {
      result += i;
    }

    return result;
  }

  public static long sequentialSum(long n) {
    return LongStream.iterate(1L, i -> i + 1L).limit(n).sum();
  }

  public static long sequentialSum2(long n) {
    return LongStream.iterate(1L, i -> i + 1L).limit(n).reduce(0L, Long::sum);
  }

  public static long parallelSum(long n) {
    return LongStream.iterate(1L, i -> i + 1L).limit(n).parallel().reduce(0L, Long::sum);
  }

  public static long rangedSum(long n) {
    return LongStream.rangeClosed(1L, n).reduce(0L, Long::sum);
  }

  public static long parallelRangedSum(long n) {
    return LongStream.rangeClosed(1L, n).parallel().reduce(0L, Long::sum);
  }

  public static long sideEffectSum(long n) {
    Accumulator acc = new Accumulator();
    LongStream.rangeClosed(1L, n).forEach(acc::add);

    return acc.getTotal();
  }

  public static long sideEffectSumParallel(long n) {
    Accumulator acc = new Accumulator();
    LongStream.rangeClosed(1L, n).parallel().forEach(acc::add);
    return acc.getTotal();
  }

  public static class Accumulator {
    private long total;

    public void add(long value) {
      total += value;
    }

    public long getTotal() {
      return total;
    }
  }
}
