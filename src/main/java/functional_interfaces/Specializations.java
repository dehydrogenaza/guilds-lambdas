package functional_interfaces;

import java.util.function.BiConsumer;
import java.util.function.IntSupplier;
import java.util.function.UnaryOperator;

public class Specializations {
  public static void main(String[] args) {
    // BiConsumer, BiFunction, BiPredicate - take two arguments
    BiConsumer<String, Integer> printAmongStars = (str, nStars) ->
        System.out.println("*".repeat(nStars) + str + "*".repeat(nStars));
    // usage
    printAmongStars.accept("Hello, World!", 3);


    // UnaryOperator, BinaryOperator - takes one/two argument(s) and returns a value of the same type
    UnaryOperator<String> surroundWithHyphens = str ->
        " --- " + str + " --- ";
    // usage
    String surrounded = surroundWithHyphens.apply("Hello, World!");
    System.out.println(surrounded);


    // Int/Long/Double Supplier/Consumer/Predicate/Function - operate on primitive types
    IntSupplier rng = () ->
        (int) (Math.random() * 1000);
    // usage
    var result = rng.getAsInt();
    System.out.println(result);
  }
}
