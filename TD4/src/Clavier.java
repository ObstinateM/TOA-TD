import java.io.*;
import java.util.Scanner;

public class Clavier {
  public static void main(String[] args) {
    if (args.length == 0) {
      System.out.println("Usage: cp <dest>");
      System.exit(1);
    }

    String dest = args.length > 0 ? args[0] : "entreeClavier.txt";

    try {
      if (new File(dest).exists()) {
        System.out.println("File " + dest + " already exists.");
        System.exit(1);
      }

      Scanner sourceBuf = new Scanner(System.in);
      PrintWriter destBuf = new PrintWriter(new FileWriter(dest));

      while (sourceBuf.hasNextLine()) {
        String line = sourceBuf.nextLine();
        if (line.equals("")) {
          break;
        }
        destBuf.println(line);
      }

      sourceBuf.close();
      destBuf.close();
    } catch (IOException e) {
      e.printStackTrace();
      System.exit(1);
    }
  }
}
