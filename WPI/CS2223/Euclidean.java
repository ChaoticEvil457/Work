import java.util.Scanner;

public class Euclidean {
    public static void main(String[] args) {
        GCDhelper();
    }

    // gets 2 user inputs, and calls GCD with a being the bigger of the two inputs
    // prints out the GCD and LCM for both inputs
    public static void GCDhelper() {
        System.out.println("This program will find the greatest common denominator for two numbers.");
        Scanner scan = new Scanner(System.in);
        int a = 0, b = 0;

        while (a < 1) {
            System.out.println("Input a positive, non-zero number:");
            a = scan.nextInt();
        }
        while (b < 1) {
            System.out.println("Input a second positive, non-zero number");
            b = scan.nextInt();
        }

        scan.close();

        if (a < b) {
            int temp = b;
            b = a;
            a = temp;
        }
        int gcd = findGCD(a, b, GLR(a, b));
        System.out.println("The GCD of " + a + " and " + b + " is " + gcd);
        System.out.println("The LCM of " + a + " and " + b + " is " + (a * b) / gcd);
    }

    // returns number of times b goes into a
    public static int GLR(int a, int b) {
        return (a - (b * (a / b)));
    }

    // finds the greatest common denominator between a and b
    public static int findGCD(int a, int b, int r) {
        System.out.println(a + " = " + b + "(" + a / b + ")" + " + " + r);
        if (r <= 0) {
            return b;
        }
        return findGCD(b, r, GLR(b, r));
    }
}
