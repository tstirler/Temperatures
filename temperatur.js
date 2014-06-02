/*
This program takes your input value and converts it from Celcius to Farenheit and vice versa.

°C to °F Deduct 32, then multiply by 5 divided by 9
°F to °C Multiply by 9, then divide by 5, then add 32
*/
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
