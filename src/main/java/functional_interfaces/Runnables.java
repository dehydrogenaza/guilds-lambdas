package functional_interfaces;

// Runnable - takes no arguments and returns nothing (operates via side effects)

public class Runnables {
  public static void main(String[] args) {
    Runnable lambda = () -> System.out.println("Hello, World!");

    runThreeTimes(lambda);
  }

  private static void runThreeTimes(Runnable lambda) {
    lambda.run();
    lambda.run();
    lambda.run();
  }
}
