package Classwork;
import java.util.*;

public class PalindromeIgnoreNonAlphanumeric {

    public static boolean isPalindrom(String s) {
        String s2 = s.replaceAll("[^a-zA-Z0-9]", "");
        StringBuilder sb = new StringBuilder(s2);
        return sb.toString().equals(sb.reverse().toString());
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String s = scan.nextLine();
        System.out.println("Ignoring non-alphanumeric characters, \nis " + s + " a palindrome? " + isPalindrom(s));

        scan.close();
    }
}
