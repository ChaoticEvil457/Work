package Summertech;

import java.util.ArrayList;
import java.util.Scanner;

public class Lists {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ArrayList<Integer> Integer = new ArrayList<Integer>();
        Scanner Scanner = new Scanner(System.in);
        for (int Practical = 0; Practical < 10; Practical = Practical + 1) {
            Integer.add(Scanner.nextInt());

        }
        for (int Int = 0; Int < Integer.size(); Int++) {
            System.out.println(Integer.get(Int));
        }
        Scanner.close();
    }

}
