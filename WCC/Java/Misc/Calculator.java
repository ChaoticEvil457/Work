package Misc;
import java.util.Scanner;

public class Calculator {

    public static double add(double a, double b) {
        return a + b;
    }

    public static double mul(double a, double b) {
        return a * b;
    }

    public static double div(double a, double b) {
        return a / b;
    }

    public static int mod(int a, int b) {
        return a % b;
    }

    public static double exp(double a, double b) {
        if (b == 0) {
            return 1;
        }
        if (b < 0) {
            return div(exp(a, b + 1), a);
        }
        return mul(exp(a, b - 1), a);
    }

    public static double root(double a) {
        return Math.sqrt(a);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String in = "";
        while (in != "exit\n") {
            System.out.println("The following functions are implemented:");
            System.out.println("\tAddition\n\tSubtraction\n\tMultiplication\n\tDivision\n\tExponent");
            System.out.println("type in the full function");
            String temp = scan.nextLine();
            temp = temp.replaceAll("", " ");
            temp = temp.replaceAll(" - ", " -");
            temp = temp.replaceAll(" -- ", " - -");
            Scanner func = new Scanner(temp);
            double a = func.nextDouble();
            String op = func.next();
            double b;
            if (op.length() > 1) {
                b = Double.parseDouble(op.substring(1));
                op = op.substring(0, 1);
            } else {
                b = func.nextDouble();
            }
            func.close();
            switch (op) {
                case "+":// a + b
                    System.out.println(" = " + add(a, b));
                    break;

                case "-":// a - b
                    System.out.println(" = " + add(a, -b));
                    break;

                case "*":// a*b
                    System.out.println(" = " + mul(a, b));
                    break;

                case "/":// a / b
                    if (b == 0) {
                        System.out.println("Divide by 0 error");
                    } else {
                        System.out.println(" = " + div(a, b));
                    }
                    break;

                case "%":// a % b
                    if ((int) a != a || (int) b != b) {
                        System.out.println(
                                "The submitted numbers cannot be modulated, please enter whole numbers");
                    } else {
                        System.out.println(" = " + mod((int) a, (int) b));
                    }
                    break;

                case "^":// a ^ b
                    System.out.println(" = " + exp(a, b));
                    break;

                default:
                    System.out.println("The given function is invalid");
            }

        }
        scan.close();
    }
}
