package edu.buet.cse.ch05;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import edu.buet.cse.ch05.model.Trader;
import edu.buet.cse.ch05.model.Transaction;

public class PuttingIntoPractice {
  public static void main(String... args) {
    Trader raoul = new Trader("Raoul", "Cambridge");
    Trader mario = new Trader("Mario", "Milan");
    Trader alan = new Trader("Alan", "Cambridge");
    Trader brian = new Trader("Brian", "Cambridge");

    List<Transaction> transactionList =
        Arrays.asList(new Transaction(brian, 2011, 300), new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400), new Transaction(mario, 2012, 710),
            new Transaction(mario, 2012, 700), new Transaction(alan, 2012, 950));

    // Query 1: Find all transactions from year 2011 and sort them by value (small to high).
    List<Transaction> transaction2011List =
        transactionList.stream().filter(t -> t.getYear() == 2011)
            .sorted((t1, t2) -> Integer.compare(t1.getValue(), t2.getValue()))
            .collect(Collectors.toList());
    transaction2011List.forEach(System.out::println);

    System.out.println();

    // Query 2: What are all the unique cities where the traders work?
    List<String> uniqueCityList = transactionList.stream().map(t -> t.getTrader().getCity())
        .distinct().collect(Collectors.toList());
    uniqueCityList.forEach(System.out::println);

    System.out.println();

    // Query 3: Find all traders from Cambridge and sort them by name.
    List<Trader> cambridgeTraderList = transactionList.stream().map(Transaction::getTrader)
        .filter(t -> t.getCity().equals("Cambridge")).distinct()
        .sorted(Comparator.comparing(Trader::getName)).collect(Collectors.toList());
    cambridgeTraderList.forEach(System.out::println);

    System.out.println();

    // Query 4: Return a string of all traders’ names sorted alphabetically.
    String traderNameStr = transactionList.stream().map(t -> t.getTrader().getName()).distinct()
        .sorted().reduce("", (s1, s2) -> s1 + " " + s2);
    System.out.println("Trader names: " + traderNameStr);

    System.out.println();

    // Query 5: Is there any trader based in Milan?
    boolean milanTraderExists = transactionList.stream().map(Transaction::getTrader)
        .anyMatch(t -> t.getCity().equals("Milan"));
    System.out.println("Is there any trader based in Milan? " + milanTraderExists);
  }
}
