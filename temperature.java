import java.util.Scanner;
public class Temperature {
  public static void main(String[] args) {
    Boolean convert = true;
    if (args.length > 0) {
      shellCommands(args);
      System.exit(0);
    }
    clearConsole();
    splashScreen();
    while (convert){
      String scale = selectScale();
      selectTemperature(scale);
      convert = runProgram();
    }
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

  //Check to see if user wants to do more calculations
  public static Boolean runProgram() {
    Scanner in = new Scanner(System.in);
    Boolean convert = true;
    System.out.println("");
    System.out.println("Do you wish to do more conversions? Y/N");
    String keepRunning = getString();
    keepRunning = keepRunning.toLowerCase();
    if (keepRunning.equals("n")) {
        convert = false;      
     } else {
      clearConsole();
     }
    return convert;
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
    Scanner in = new Scanner(System.in);
    System.out.print(" > "); // Add a nice prompt.
    String userInput = in.nextLine();
    userInput = userInput.toLowerCase();
    return userInput;
  }

  //Grabs the nest numeric input from the keyboard as an double.
  public static double getNumber() {
    Scanner in = new Scanner(System.in);
    System.out.print(" > "); // Add a nice prompt.
    double userNumberInput = in.nextInt();
    return userNumberInput;
  }

  //This selects if the user wants to convert from C or F.
  public static String selectScale() {
    System.out.println("Do you wish to convert from (C)elcius to Farenheit,\n          or from (F)arenheit to Celcius?");
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
    conversion(userTemp, scale);
  }

  public static void conversion(double userTemp, String scale) {
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

  //Catch commandline input
  public static void shellCommands(String passedInput[]) {
    if (passedInput[0].equals("?")){
      System.out.println("");
      System.out.println("Usage:");
      System.out.println("Run Temperature without arguments for a menu-based conversion,\nor run with arguments for a quick conversion.");
      System.out.println("Commandline arguments are used like this:");
      System.out.println("Temperature [temperature to convert] [from scale] [to scale]");
      System.out.println("Supported scales: (C)elcius and (F)arenheit.");
      System.out.println("");
      System.out.println("Example:\ntemperature 100 F C\nWill convert 100 Farenheit into Celcius.");
      System.exit(0);
    }
    String firstArgString = passedInput[0];
    String secondArg  = passedInput[1];
    String thirdArg = passedInput[2];
    numberCheck(firstArgString);
    double firstArg = Double.valueOf(firstArgString);
    conversion(firstArg, secondArg);
  }

  public static void numberCheck(String isANumber) {
    double check;
    try {
      check = Double.valueOf(isANumber);
    } catch (NumberFormatException e) {
      //Will Throw exception if isANumber isn't a number!
      System.out.println("The first argument passed was not a number.");
      System.exit(1);
    }
  }

  //Simple clearing of the console.
  public static void clearConsole() {
    for (int i = 0; i < 80; ++i) System.out.println();
  }
}