package functional_interfaces;

import java.util.Random;
import java.util.function.Supplier;

// Supplier - takes no arguments and returns a value

public class Suppliers {
  public static void main(String[] args) {
    var rng = new Random();
    Supplier<Integer> lambda = () -> rng.nextInt(100);

    printSuppliedValues(lambda);
  }

  private static void printSuppliedValues(Supplier<Integer> lambda) {
    System.out.println(lambda.get());
    System.out.println(lambda.get());
    System.out.println(lambda.get());
  }
}
