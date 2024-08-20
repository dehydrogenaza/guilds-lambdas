package functional_interfaces;

import java.util.function.Function;

// Function - takes an argument and returns a value (possibly of a different type)

public class Functions {
  public static void main(String[] args) {
    Function<String, Integer> lambda = str -> str.replace(" ", "")
        .length();

    transformSomeValue(lambda);
//    chainFunctions();
  }

  private static void transformSomeValue(Function<String, Integer> lambda) {
    String input = "Hello with spaces";
    System.out.println("Raw input length: " + input.length());
    System.out.println("Transformed length: " + lambda.apply(input));
  }

  private static void chainFunctions() {
    Function<Integer, String> repeatStarsSquared = n ->
        "*".repeat(n * n);

    Function<String, Integer> getLengthDoubled = str ->
        str.length() * 2;

    Function<Integer, String> repeatHashesSquared = n ->
        "#".repeat(n * n);

    Integer result1 = getLengthDoubled.compose(repeatStarsSquared)
        .apply(6);
    System.out.println("Composed (before): " + result1);

    String result2 = getLengthDoubled.andThen(repeatHashesSquared)
        .apply("5long");
    System.out.println("Composed (after): " + result2 + " (length: " + result2.length() + ")");
  }
}
