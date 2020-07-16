package edu.buet.cse.ch03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExecuteAround {
  public static void main(String... args) {
    try {
      // read one line by invoking another method
      String oneLine = processFileLimited();
      System.out.println(oneLine);

      // read one line using lambda expression
      BufferedReaderProcessor processor1 = bf -> bf.readLine();
      String result1 = processFile(processor1);
      System.out.println(result1);

      // read two lines using lambda expression
      BufferedReaderProcessor processor2 = bf -> bf.readLine() + bf.readLine();
      String result2 = processFile(processor2);
      System.out.println(result2);
    } catch (IOException ex) {
      System.err.println(ex);
    }
  }

  private static String processFileLimited() throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(
        ExecuteAround.class.getResourceAsStream("/edu/buet/cse/ch03/data.txt")));

    return reader.readLine();
  }

  private static String processFile(BufferedReaderProcessor processor) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(
        ExecuteAround.class.getResourceAsStream("/edu/buet/cse/ch03/data.txt")));

    return processor.process(reader);
  }
}
