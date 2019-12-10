package ACSL;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class JustinHuangACSLC2 {
    public static void main(String args[]) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("acsl2data.txt"));
        while (true) {
            String st1 = scan.next();
            String st2 = scan.next();
            String answer = left(st1, st2, "");
            String answer2 = right(st1, st2, "");
            String answer3 = compare(answer, answer2, "");
            answer = left(st2, st1, "");
            answer2 = right(st2, st1, "");
            String answer4 = compare(answer, answer2, "");
            String lastAnswer = compare(answer3, answer4, "");
            lastAnswer = sort(lastAnswer);
            System.out.println(lastAnswer);
            try {
                scan.nextLine();
            } catch (Exception e) {
                break;
            }
        }
        scan.close();
    }

    public static String left(String st1, String st2, String answer) {
        for (int i = 0; i < st1.length(); i++) {
            for (int j = 0; j < st2.length(); j++) {
                try {
                    if (st1.charAt(i) == st2.charAt(j)) {
                        answer += st1.charAt(i);
                        st1 = st1.substring(i + 1);
                        st2 = st2.substring(j + 1);
                        j = -1;
                        i = 0;
                    }
                } catch (Exception e) {
                    j = 0;
                    i = 0;
                }
            }
        }
        if(st1.length()>0&&st2.length()>0){
            for(int j=0;j<st2.length();j++) {
                if (st1.charAt(st1.length()-1) == st2.charAt(j)) {
                    answer+=st1.charAt(j);
                }
            }
        }
        return (answer);
    }

    public static String right(String st1, String st2, String answer) {
        for (int i = st1.length() - 1; i > 0; i--) {
            for (int j = st2.length() - 1; j > -1; j--) {
                try {
                    if (st1.charAt(i) == st2.charAt(j)) {
                        answer += st1.charAt(i);
                        st1 = st1.substring(0, i);
                        st2 = st2.substring(0, j);
                        j = st2.length();
                        i = st1.length() - 1;
                    }
                } catch (Exception e) {
                    j = st2.length() - 1;
                    i = st1.length() - 1;
                }
            }
        }
        if(st1.length()>0&&st2.length()>0){
            for(int j=0;j<st2.length();j++) {
                if (st1.charAt(0) == st2.charAt(j)) {
                    answer+=st1.charAt(0);
                }
            }
        }
        return (answer);
    }

    public static String compare(String answer, String answer2, String answer3) {
        for (int i = 0; i < answer.length(); i++) {
            for (int j = 0; j < answer2.length(); j++) {
                if (answer.charAt(i) == answer2.charAt(j) && !answer3.contains("" + answer.charAt(i))) {
                    answer3 += answer.charAt(i);
                }
            }
        }
        return (answer3);
    }

    public static String sort(String answer3) {
        int[] ray = new int[answer3.length()];
        for (int i = 0; i < answer3.length(); i++) {
            ray[i] = answer3.charAt(i);
        }
        Arrays.sort(ray);
        String sorted = "";
        for (int i = 0; i < answer3.length(); i++) {
            sorted += (char) ray[i];
        }
        return (sorted);
    }
}
