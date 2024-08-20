package usage;

import java.util.function.IntUnaryOperator;
import java.util.function.Supplier;

public class MethodReferenceTestbed {
  private final int instanceField;

  public MethodReferenceTestbed(int instanceValue) {
    this.instanceField = instanceValue;
  }

  public void testMethodRefs() {
    printResult(MethodReferenceTestbed::staticMethod); //Static reference

    printResult(this::instanceMethod); //Instance reference from inside the class (through "this")

    SomeSource source = new SomeSource();
    printResult(source::externalInstanceMethod); //Instance reference from outside the class

    printResult(SomeSource::new); //Constructor reference
  }

  public void printResult(IntUnaryOperator operator) {
    System.out.println(operator.applyAsInt(instanceField));
  }

  public void printResult(Supplier<SomeSource> supplier) {
    SomeSource operation = supplier.get();
    System.out.println(operation.externalInstanceMethod(instanceField));
  }

  public static int staticMethod(int initial) {
    return initial + 1;
  }

  public int instanceMethod(int initial) {
    return initial - 1;
  }

  public static class SomeSource {
    public int externalInstanceMethod(int a) {
      return -a;
    }
  }
}
