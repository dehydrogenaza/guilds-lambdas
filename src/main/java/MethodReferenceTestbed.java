import java.util.function.IntBinaryOperator;
import java.util.function.IntUnaryOperator;
import java.util.function.Supplier;

public class MethodReferenceTestbed {
  private static final int STATIC_VALUE = 100;
  private static final int OTHER_STATIC_VALUE = 4;

  private final int instanceValue;

  public MethodReferenceTestbed(int instanceValue) {
    this.instanceValue = instanceValue;
  }

  public void printResult(IntUnaryOperator operator) {
    System.out.println(operator.applyAsInt(STATIC_VALUE));
  }

  public void printResult(IntBinaryOperator operator) {
    System.out.println(operator.applyAsInt(STATIC_VALUE, OTHER_STATIC_VALUE));
  }

  public void printResult(Supplier<SomeOperation> supplier) {
    SomeOperation operation = supplier.get();
    System.out.println(operation.apply(STATIC_VALUE));
  }

  public void printDefault() {
    printResult(this::addNothing);
//    printResult(IntUnaryOperator.identity()); //helper method
  }

  public static int addStatic(int initial) {
    return initial + 1;
  }

  public int addInstanceValue(int initial) {
    return initial + instanceValue;
  }

  public int divide(int dividend, int divisor) {
    return dividend / divisor;
  }

  private int addNothing(int initial) {
    return initial;
  }

  public static class SomeOperation {
    public int apply(int a) {
      return -a;
    }
  }
}
