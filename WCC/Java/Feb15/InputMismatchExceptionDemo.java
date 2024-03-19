package Feb15;

import java.util.Scanner;

public class InputMismatchExceptionDemo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("enter an input");
                scan.nextInt();
                break;
            } catch (Exception InputMismatchException) {
                System.out.println("Incorrect Input, Integer Expected");
                scan.nextLine();
            }
        }
    }
}