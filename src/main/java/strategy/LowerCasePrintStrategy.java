package strategy;

public class LowerCasePrintStrategy implements DisplayStrategy {
  @Override
  public void display(String text) {
    System.out.println("- " + text.toLowerCase());
  }
}
