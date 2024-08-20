package strategy;

public class UpperCasePrintStrategy implements DisplayStrategy {
  @Override
  public void display(String text) {
    System.out.println("- " + text.toUpperCase());
  }
}
