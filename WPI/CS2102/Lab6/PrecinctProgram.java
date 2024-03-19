import java.util.Scanner;

public class PrecinctProgram {
    public static void main(String[] args) {
        Precinct worcester12;
        Scanner keyboard = new Scanner(System.in);
        String preName = keyboard.nextLine();
        String preAddr = keyboard.nextLine();
        int pop = keyboard.nextInt();
        worcester12 = new Precinct(preName, preAddr, pop);
        System.out.println(worcester12);
        worcester12 = worcester12.grow(keyboard.nextInt());
        System.out.println(worcester12);
    }
}
/*
 * using nextLine for the preName and preAddr will cause the scanner to read the
 * enters.
 * Because the first thing seen is a nextInt, it get that integer, then sees
 * that there is a \n chatacter
 * and then stores that in preName, then it sees the next \n character, which
 * comes after Worcester12, and stores that in preAddr
 * Moving pop to the last thing read removes this problem
 */