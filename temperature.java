import java.util.Scanner;
public class temperature {
  public static void main(String[] args) {
  }

  public static double celToFar(celTemp) {
    return celtemp;
  }

  public static double farToCel(farTemp) {
    return farTemp;
  }

  public static void splashScreen {
    System.out.println("");
    System.out.println(" ___________________________________________________ ");
    System.out.println("|                                                   |");
    System.out.println("|            Simple temperature converter           |");
    System.out.println("|___________________________________________________|");
    System.out.println("");
    System.out.println("");
  }
}




var temperature = 100;
var tempscale = "f";

var celToFar = function(oldTemp) {  //Define the Celcius to Farenheit function
    var newTemperature = (oldTemp-32)*(5/9); //Convert the temperatur
    return newTemperature.toPrecision(4); //Push back the new temperatur
};

var farToCel = function(oldTemp) {  //Define the Farenheit to Celcius function
    var newTemperature = ((oldTemp*9)/5)+32; //Convert the temperatur
    return newTemperature.toPrecision(4); //Push back the new temperatur
};


if (tempscale.toLowerCase() === "c") { // Check to see if you are converting Celcius
    console.log(temperature + " in Celcius is " + celToFar(temperature) + " in Farenheit.");
} else if (tempscale.toLowerCase() === "f") { // Check to see if you are converting Farenheit
    console.log(temperature + " in Farenheit is " + farToCel(temperature) + " in Celcius.");
} else {
    console.log("Looks like you did not select a correct Scale.")
}