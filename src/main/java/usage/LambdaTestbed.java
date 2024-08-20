package usage;

import java.util.function.IntSupplier;

public class LambdaTestbed {
  private final int instanceField;

  public LambdaTestbed(int field) {
    this.instanceField = field;
  }

  public void testLambdas() {
    printInt(() -> 1); //No capture, only internal variables
//    new IntSupplier() {
//      @Override
//      public int getAsInt() {
//        return 1;
//      }
//    };

    int localVariable = 10;
    printInt(() -> 2 * localVariable); //Captures the variable
//    new IntSupplier() {
//      private final int closure = localVariable;
//      @Override
//      public int getAsInt() {
//        return 2 * closure;
//      }
//    };


    printInt(() -> instanceField); //Captures the instance
//    new IntSupplier() {
//      private final usage.LambdaTestbed closure = usage.LambdaTestbed.this;
//      @Override
//      public int getAsInt() {
//        return closure.instanceField;
//      }
//    };

    printInt(() -> { //Brackets for multi-line lambdas
      StringBuilder builder = new StringBuilder();
      for (int i = 0; i < 4; i++) {
        builder.append("4");
      }
      return Integer.parseInt(builder.toString());
    });
  }

  private void printInt(IntSupplier supplier) {
    System.out.println(supplier.getAsInt());
  }
}
