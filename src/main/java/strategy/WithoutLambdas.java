package strategy;

import java.util.List;

public class WithoutLambdas {
  public static void main(String[] args) {
    List<String> characters = List.of("Winnie the Pooh", "Piglet", "Eeyore", "Tigger", "Rabbit", "Kanga", "Roo", "Owl", "Christopher Robin");

    //print uppercased
    System.out.println("\nHundred Acre Wood denizens:");
    var upperCaseHandler = new CharacterDisplayHandler(new UpperCasePrintStrategy());
    upperCaseHandler.handle(characters);

    //print lowercased
    System.out.println("\nHundred Acre Wood denizens:");
    var lowerCaseHandler = new CharacterDisplayHandler(new LowerCasePrintStrategy());
    lowerCaseHandler.handle(characters);
  }
}
