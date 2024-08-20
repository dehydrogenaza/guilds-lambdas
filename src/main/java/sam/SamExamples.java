package sam;

public class SamExamples {
  public static void main(String[] args) {
    System.out.println("\nAMAZING FUNCTIONS");
    beAmazed(seconds -> "- You've been amazed for " + seconds + " seconds!");
    beAmazed(seconds -> "- You've been amazed for " + seconds / 60 + " minutes!");

    System.out.println("\nBORING FUNCTIONS");
    beBored(seconds -> "- You've been bored for " + seconds / 60 / 60 + " hours!");
    beBored(new BoringFunction() {
      @Override
      public String bore(long seconds) {
        return "- You've been bored for " + seconds / 60 / 60 / 24 + " days!";
      }

      @Override
      public String toString() {
        return "BoreForDays";
      }
    });
  }

  private static void beAmazed(AmazingFunction amazingFunction) {
    String amazement = amazingFunction.amaze(7200);
    System.out.println(amazement);
  }

  private static void beBored(BoringFunction boringFunction) {
    String boringFunctionName = boringFunction.toString();
    System.out.println("Boring function name: " + boringFunctionName);

    String boredom = boringFunction.bore(7200);
    System.out.println(boredom);

    String constantBoredom = boringFunction.constantlyBore();
    System.out.println(constantBoredom);
  }
}
