package Classwork;
import java.util.Scanner;

public class PasswordValid {
    public static boolean isValidPassword(String s) {
        // Rules:
        // at least 8 characters
        // (length<8)
        // consists of only alphanumeric characters
        // (string without alphanumeric characters length = 0)
        // constains at least 2 digits
        // (string with only numbers has length > 2)

        if (s.length() < 8 || s.replaceAll("[a-zA-Z0-9]", "").length() != 0
                || s.replaceAll("[^0-9]", "").length() < 2) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a password: ");
        String s = scan.nextLine();

        System.out.println(isValidPassword(s) ? s + " is a valid password" : s + " is not a valid password");

        scan.close();
    }
}
