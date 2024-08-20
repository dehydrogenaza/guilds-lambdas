package mistakes;

import java.util.function.IntSupplier;

public class LambdaMistakes {
  private static int field = 20;

  public static void main(String[] args) {
    int closureVariable = 3;
    printInt(() -> {
//      closureVariable = -closureVariable;
      return 10 * closureVariable;
    }); //side effects


    int localVariable = 15;
//    localVariable = 25;
    printInt(() -> 2 * localVariable); //use effectively final variables in closures
//    localVariable = 50;


//    field = 1000;
    printInt(() -> field); //fields are not allocated on the stack, so they're safe to use
//    field = 5000;

    int[] numbers = {1, 2, 3, 4, 5};
    for (int i = 0; i < numbers.length; i++) {
      int number = numbers[i];
      printInt(() -> -number);
//      printInt(() -> numbers[i]); //not effectively final!
    }
  }

  private static void printInt(IntSupplier supplier) {
    System.out.println(supplier.getAsInt());
  }

  private static void printArgument(int arg) {
    printInt(() -> arg);
  }
}
