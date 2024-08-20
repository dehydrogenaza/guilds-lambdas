package usage;

public class Usage {
  public static void main(String[] args) {
    System.out.println("Testing Lambdas");
    new LambdaTestbed(333).testLambdas();

    System.out.println("Testing Method Refs");
    new MethodReferenceTestbed(5000).testMethodRefs();
  }
}
