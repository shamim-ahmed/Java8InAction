package edu.buet.cse.ch03;

public class HelloWorld {
  public static void main(String... args) {
    Runnable r = () -> System.out.println("Hello World !!");
    Thread t = new Thread(r);
    t.start();

    try {
      t.join();
    } catch (InterruptedException ex) {
      System.err.println(ex);
    }

    System.out.println("The End");
  }
}
