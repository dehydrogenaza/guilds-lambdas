package functional_interfaces;

import java.util.function.Predicate;

// Predicate - takes an argument and returns a boolean

public class Predicates {
  public static void main(String[] args) {
    checkConditions(i -> i % 3 == 0);
//    shortCircuitLogicOperations();
  }

  private static void checkConditions(Predicate<Integer> lambda) {
    System.out.println("\nBasic test:");
    for (int i = 1; i <= 15; i++) {
      if (lambda.test(i)) {
        System.out.printf("- %d passed the test\n", i);
      }
    }

    System.out.println("\nNegated:");
    for (int i = 1; i <= 15; i++) {
      if (lambda.negate().test(i)) {
        System.out.printf("- %d failed the test\n", i);
      }
    }

    System.out.println("\nAnd (is even):");
    Predicate<Integer> isEven = n -> n % 2 == 0;
    for (int i = 1; i <= 15; i++) {
      if (lambda.and(isEven).test(i)) {
        System.out.printf("- %d passed the test and is even\n", i);
      }
    }

    System.out.println("\nOr (is greater than 10):");
    Predicate<Integer> isGreaterThanTen = n -> n > 10;
    for (int i = 1; i <= 15; i++) {
      if (lambda.or(isGreaterThanTen).test(i)) {
        System.out.printf("- %d passed the test and/or is greater than 10\n", i);
      }
    }
  }

  private static void shortCircuitLogicOperations() {
    System.out.println("\nShort-circuiting OR/AND:\n");
    Predicate<Integer> firstCondition = n -> {
      System.out.println("Checking FIRST CONDITION");
      return n > 0;
    };
    Predicate<Integer> secondCondition = n -> {
      System.out.println("Checking SECOND CONDITION");
      return n % 2 == 0;
    };

    // FIRST, SECOND
    boolean result1 = firstCondition.or(secondCondition).test(-2);
    System.out.println("Result of OR with -2: " + result1);
    System.out.println();

    // FIRST
    boolean result2 = firstCondition.or(secondCondition).test(2);
    System.out.println("Result of OR with 1: " + result2);
    System.out.println();


    // FIRST, SECOND
    boolean result3 = firstCondition.and(secondCondition).test(2);
    System.out.println("Result of AND with 2: " + result3);
    System.out.println();


    // FIRST
    boolean result4 = firstCondition.and(secondCondition).test(-2);
    System.out.println("Result of AND with -2: " + result4);
    System.out.println();
  }
}
