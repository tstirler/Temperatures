import java.util.Scanner;
public class Temperature {
  public static void main(String[] args) {
    Boolean convert = true;
    String fromScale;
    String toScale;
    double userTemp;
    double newTemp;
    if (args.length > 0) {
      shellCommands(args);
      System.exit(0);
    }
    clearConsole();
    splashScreen();
    while (convert){
      int scale = selectScale();
      userTemp = selectTemperature();
      conversion(userTemp, scale);
      convert = runProgram();
    }
  }

  //Method for converting Celsius to Farenheit
  public static double celToFar(double calcTemp) {
    double newTemp = ((calcTemp * 9.0) / 5.0) + 32;
    return newTemp;
  }

  //Method for converting Celsius to Kelvin
  public static double celToKel(double calcTemp) {
    double newTemp = calcTemp + 273.15;
    return newTemp;
  }

  //Method for converting Kelvin to Celsius
  public static double kelToCel(double calcTemp) {
    double newTemp = calcTemp - 273.15;
    return newTemp;
  }

  //Method for converting Farenheit to Celsius
  public static double farToCel(double calcTemp) {
    double newTemp = (calcTemp - 32) * (5.0 / 9.0);
    return newTemp;
  }

  public static double farToKel(double calcTemp) {
    double newTemp = farToCel(calcTemp);
    newTemp = celToKel(newTemp);
    return newTemp;
  }

  public static double kelToFar(double calcTemp) {
    double newTemp = kelToCel(calcTemp);
    newTemp = celToFar(newTemp);
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

  //Grabs the nest numeric input from the keyboard as an integer.
  public static int getNumberInt() {
    Scanner in = new Scanner(System.in);
    System.out.print(" > "); // Add a nice prompt.
    int userNumberInputInt = in.nextInt();
    return userNumberInputInt;
  }

  //This selects if the user wants to convert from C or F.
  public static int selectScale() {
    System.out.println("Do you wish to convert from:");
    System.out.println("1: Celsius to Farenheit");
    System.out.println("2: Farenheit to Celsius");
    System.out.println("3: Celsius to Kelvin");
    System.out.println("4: Farenheit to Kelvin");
    System.out.println("5: Kelvin to Celsius");
    System.out.println("6: Kelvin to Farenheit");
    int userScaleInput = getNumberInt();
    switch (userScaleInput) {
      case 1: System.out.println("");
              System.out.println("You've selected Celsius to Farenheit.");
              break;
      case 2: System.out.println("");
              System.out.println("You've selected Farenheit to Celsius.");
              break;
      case 3: System.out.println("");
              System.out.println("You've selected Celsius to Kelvin.");
              break;
      case 4: System.out.println("");
              System.out.println("You've selected Farenheit to Kelvin.");
              break;
      case 5: System.out.println("");
              System.out.println("You've selected Kelvin to Celsius.");
              break;
      case 6: System.out.println("");
              System.out.println("You've selected Kelvin to Farenheit.");
              break;
    }
    return userScaleInput;
  }

  //Get the temperature the user wants to convert.
  public static double selectTemperature() {
    System.out.println("What temperature would you like to convert?");
    double userTemp = getNumber();
    return userTemp;
  }

  public static void conversion(double userTemp, int scale) {
    double newTemp;
    switch (scale) {
      case 1: newTemp = celToFar(userTemp);
              System.out.println(userTemp + " in Celsius is " + newTemp + " in Farenheit.");
              break;
      case 2: newTemp = farToCel(userTemp);
              System.out.println(userTemp + " in Farenheit is " + newTemp + " in Celsius.");
              break;
      case 3: newTemp = celToKel(userTemp);
              System.out.println(userTemp + " in Celsius is " + newTemp + " in Kelvin.");
              break;
      case 4: newTemp = farToKel(userTemp);
              System.out.println(userTemp + " in Farenheit is " + newTemp + " in Kelvin.");
              break;
      case 5: newTemp = kelToCel(userTemp);
              System.out.println(userTemp + " in Kelvin is " + newTemp + " in Celsius.");
              break;
      case 6: newTemp = kelToFar(userTemp);
              System.out.println(userTemp + " in Kelvin is " + newTemp + " in Farenheit.");
              break;
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
      System.out.println("Supported scales: (C)elsius (F)arenheit and (K)elvin");
      System.out.println("");
      System.out.println("Example:\ntemperature 100 F C\nWill convert 100 Farenheit into Celsius.");
      System.exit(0);
    }
    String firstArgString = passedInput[0];
    String secondArg  = passedInput[1];
    String thirdArg = passedInput[2];
    numberCheck(firstArgString);
    double firstArg = Double.valueOf(firstArgString);
    int scale = shellScale(secondArg, thirdArg);
    conversion(firstArg, scale);
  }

  public static int shellScale(String scaleOne, String scaleTwo) {
    int scale;
    scaleOne = scaleOne.toLowerCase();
    scaleTwo = scaleTwo.toLowerCase();
    switch (scaleOne) {
      case "c": switch (scaleTwo) {
                  case "f": scale = 1;
                            break;
                  case "k": scale = 3;
                            break;
                  default:  scale = 0;
                            System.out.println("You did not enter a valid second temperature-scale.");
                            break;
                }
                break;
      case "f": switch (scaleTwo) {
                  case "c": scale = 2;
                            break;
                  case "k": scale =4;
                            break;
                  default:  scale = 0;
                            System.out.println("You did not enter a valid second temperature-scale.");
                            break;
                }
                break;
      case "k": switch (scaleTwo) {
                  case "c": scale = 5;
                            break;
                  case "f": scale = 6;
                            break;
                  default:  scale = 0;
                            System.out.println("You did not enter a valid second temperature-scale.");
                            break;
                }
                break;
      default:  System.out.println("You did not enter a valid first temperature-scale.");
                scale = 0;
                System.exit(0);
                break;
    }
    return scale;
  }

  //This cheks to see it the passed string could be converted to a number.
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
