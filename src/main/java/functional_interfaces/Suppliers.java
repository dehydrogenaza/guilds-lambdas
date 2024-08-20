package functional_interfaces;

import java.util.Random;
import java.util.function.Supplier;

// Supplier - takes no arguments and returns a value
public class Suppliers {
  public static void main(String[] args) {
    var rng = new Random();
    useLambda(() -> rng.nextInt(100));
  }

  private static void useLambda(Supplier<Integer> lambda) {
    System.out.println(lambda.get());
    System.out.println(lambda.get());
    System.out.println(lambda.get());
  }
}
