import java.util.function.IntSupplier;

public class LambdaUsage {
  private static int field = 333;

  public static void main(String[] args) {
    testLambdas();
//    testMethodRefs();
  }

  private static void testLambdas() {
    //1
    printInt(() -> 1);

    //20
    int localVariable = 10;
    printInt(() -> 2 * localVariable);

    //333
    printInt(() -> field);

    //4000
    printArgument(4000);

    //55555
    printInt(() -> {
      StringBuilder builder = new StringBuilder();
      for (int i = 0; i < 5; i++) {
        builder.append("5");
      }
      return Integer.parseInt(builder.toString());
    });
  }

  private static void printInt(IntSupplier supplier) {
    System.out.println(supplier.getAsInt());
  }

  private static void printArgument(int arg) {
    printInt(() -> arg);
  }

  private static void testMethodRefs() {
    var testbed = new MethodReferenceTestbed(5000);

    //Static reference
    testbed.printResult(MethodReferenceTestbed::addStatic);

    //Instance reference
    testbed.printResult(testbed::addInstanceValue);

    //Instance reference from inside the class (through "this")
    testbed.printDefault();

    //Overloaded
    testbed.printResult(testbed::divide);

    //Constructor reference
    testbed.printResult(MethodReferenceTestbed.SomeOperation::new);
  }
}
