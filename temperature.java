import java.util.Scanner;
public class temperature {
  public static void main(String[] args) {
    clearConsole();
    splashScreen();
    String scale = selectScale();
    selectTemperature(scale);
  }

  //Method for converting Celcius to Farenheit
  public static double celToFar(double calcTemp) {
    double newTemp = ((calcTemp * 9.0) / 5.0) + 32;
    return newTemp;
  }

  //Method for converting Farenheit to Celcius
  public static double farToCel(double calcTemp) {
    double newTemp = (calcTemp - 32) * (5.0 / 9.0);
    return newTemp;
  }

  public static void splashScreen() {
    System.out.println("");
    System.out.println("   ___________________________________________________ ");
    System.out.println("  |                                                   |");
    System.out.println("  |            Simple temperature converter           |");
    System.out.println("  |___________________________________________________|");
    System.out.println("");
    System.out.println("");
  }

  //Grabs the nest text input from the keyboard as a string.
  public static String getString() {
    System.out.print(" > "); // Add a nice prompt.
    Scanner in = new Scanner(System.in);
    String userInput = in.nextLine();
    userInput = userInput.toLowerCase();
    return userInput;
  }

  //Grabs the nest numeric input from the keyboard as an double.
  public static double getNumber() {
    System.out.print(" > "); // Add a nice prompt.
    Scanner in = new Scanner(System.in);
    double userNumberInput = in.nextInt();
    return userNumberInput;
  }

  //This selects if the user wants to convert from C or F.
  public static String selectScale() {
    System.out.println("Do you wish to convert from (C)elcius to Farenheit, or from (F)arenheit to Celcius?");
    String userScaleInput = getString();
    if (userScaleInput.equals("f")) {
      System.out.println("You've selected Farenheit.");
      return userScaleInput;
    } else if (userScaleInput.equals("c")) {
      System.out.println("You've selected Celcius.");
      return userScaleInput;
    } else {
      System.out.println("You have not selected a usable temperature scale.");
    }
    return "not selected";
  }

  //Get the temperature the user wants to convert.
  public static void selectTemperature(String scale) {
    System.out.println("What temperature would you like to convert?");

    double userTemp = getNumber();
    System.out.println();
    System.out.println(userTemp + " in " + scale.toUpperCase() + " is ");
    if (scale.equals("f")) {
      double newTemp = farToCel(userTemp);
      System.out.println(newTemp + " in Celcius.");
      System.out.println();
    } else if (scale.equals("c")) {
      double newTemp = celToFar(userTemp);
      System.out.println(newTemp + " in Farenheit.");
      System.out.println();
    }
  }

  //Simple clearing of the console.
  public static void clearConsole() {
    for (int i = 0; i < 80; ++i) System.out.println();
  }
}