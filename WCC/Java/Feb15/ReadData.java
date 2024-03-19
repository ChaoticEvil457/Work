package Feb15;

import java.nio.file.Paths;
import java.util.Scanner;

public class ReadData {
    public static void main(String[] args) throws Exception {
        try (Scanner scan = new Scanner(Paths.get("scores12.txt"));) {
            while (scan.hasNext()) {
                String firstName = scan.next();
                String mi = scan.next();
                String lastName = scan.next();
                int score = scan.nextInt();
                System.out.println(firstName + " " + mi + " " + lastName + " " + score);
            }

        }
    }
}
