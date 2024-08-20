import java.util.List;

public class Intro {
  public static void main(String[] args) {
    List<String> characters = List.of("Winnie the Pooh", "Piglet", "Eeyore", "Tigger", "Rabbit", "Kanga", "Roo", "Owl", "Christopher Robin");

    //print uppercased
    System.out.println("\nHundred Acre Wood denizens:");
    characters.forEach(ch -> System.out.println("- " + ch.toUpperCase()));
//    characters.forEach((String ch) -> System.out.println("- " + ch.toUpperCase()));

    //print lowercased
    System.out.println("\nHundred Acre Wood denizens:");
    characters.forEach(ch -> System.out.println("- " + ch.toLowerCase()));
  }
}
