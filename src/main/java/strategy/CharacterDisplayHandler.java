package strategy;

import java.util.List;

public class CharacterDisplayHandler {
  private final DisplayStrategy strategy;

  public CharacterDisplayHandler(DisplayStrategy strategy) {
    this.strategy = strategy;
  }

  public void handle(List<String> characters) {
    for (String ch : characters) {
      strategy.display(ch);
    }
  }
}
