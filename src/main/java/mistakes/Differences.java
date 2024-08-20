package mistakes;

import java.util.function.Supplier;

public class Differences {
  public static void main(String[] args) {
    var tester = new DifferenceTester();
    tester.demonstrateCapture();
//    tester.crashWithLambda();
//    tester.crashWithReference();
  }

  static class DifferenceTester {
    String someString;
    WillItCrash willCrash;

    void demonstrateCapture() {
      someString = "Original";
      Supplier<String> lambda = () -> someString.toUpperCase();
      Supplier<String> methodRef = someString::toUpperCase;

      someString = "Changed";
      System.out.println("Lambda result: " + lambda.get());
      System.out.println("Method Ref result: " + methodRef.get());
    }

    void crashWithLambda() {
      // lambdas are closed over "this" reference
      // they use "this" to access instance fields WHEN CALLED
      willCrash = null;
      runSomeCode(() -> willCrash.letsSee());
    }

    void crashWithReference() {
      // method refs are closed over *field values*
      // they capture the value AT EVALUATION TIME
      willCrash = null;
      runSomeCode(willCrash::letsSee);
    }

    void runSomeCode(Runnable lambda) {
      lambda.run();
      System.out.println("DONE!");
    }

  }

  static class WillItCrash {
    void letsSee() {
      System.out.println("I have not crashed!");
    }
  }
}
