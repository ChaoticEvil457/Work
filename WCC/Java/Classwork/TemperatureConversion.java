package Classwork;
import java.util.Scanner;

public class TemperatureConversion {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.print("Please enter a Fahrenheit temperature to convert to Celsius: ");

    // gets user input temperature
    double fahrenheit = scan.nextDouble();

    // converts ferenheit to celsius
    double celsius = ((fahrenheit - 32) * 5 / 9);

    // rounds to the nearest hundredth
    celsius -= celsius % 0.01;
    System.out.println("\nDegrees fahrenheit:\t" + fahrenheit + "\n\nDegrees Celsius:\t" + celsius);
    scan.close();
  }
}
