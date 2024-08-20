package sam;

@FunctionalInterface
public interface BoringFunction {
  String bore(long seconds);

//  String boreMore(long seconds);

  default String constantlyBore() {
    return "- You're always bored!";
  }
}
