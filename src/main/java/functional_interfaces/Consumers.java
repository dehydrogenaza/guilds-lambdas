package functional_interfaces;

import java.util.function.Consumer;

// Consumer - takes an argument and returns nothing (operates via side effects)

public class Consumers {
  public static void main(String[] args) {
    Consumer<String> lambda = str -> System.out.println(str.toUpperCase());

    performSideEffect(lambda);
//    multipleConsumers();
  }

  private static void performSideEffect(Consumer<String> lambda) {
    String hello = "Hello, World!";
    String goodbye = "Goodbye, World!";
    lambda.accept(hello);
    lambda.accept(goodbye);
  }

  private static void multipleConsumers() {
    Consumer<String> printUpperCase = str ->
        System.out.println(str.toUpperCase());

    Consumer<String> printLength = str ->
        System.out.println("Length: " + str.length());

    printUpperCase.andThen(printLength).accept("Hello, World!");
  }
}
