package ACSL;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class JustinHuangACSLC1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner data = new Scanner(new File("ACSLData.txt"));
        String number = data.next();
        ArrayList<String> ray = new ArrayList<String>();
        int n = data.nextInt();
        int lines = 0;
        while (data.hasNextLine()) {
            lines++;
            data.nextLine();
        }
        data = new Scanner(new File("ACSLData.txt"));
        while (lines != 0) {
            lines--;
            try {
                data.nextLine();
            } catch (Exception e) {
            }
            for (int i = 0; i < number.length() - n + 1; i++) {
                ray.add(number.substring(i, i + n));
            }
            String answer = "";
            for (int i = 0; i < number.length(); i++) {
                try {
                    while (ray.size() > 1) {
                        int extra = 0;
                        for (int k = 0; k < n; k++) {
                            if (ray.get(0).charAt(k) - 48 + ray.get(1).charAt(k) - 48 >= 10) {
                                extra = (int) Math.pow(10, n + 1);
                            }
                            answer=addNums(answer,extra,ray,0,n);
                        }
                    }

                } catch (Exception e) {

                }
            }
            System.out.println(answer);
            ray.clear();
            try {
                number = data.next();
                n = data.nextInt();
            } catch (Exception e) {

            }
        }
        data.close();
    }

    public static String addNums(String answer, int extra, ArrayList<String> ray, int j,int n) {
        if (ray.size()==1) {
            return(answer);
        }
        if(j>=n){
            j=-1;
            ray.set(0,answer);
            answer="";
            ray.remove(1);
        }
        else {
            if(ray.get(0).charAt(j) - 48 + ray.get(1).charAt(j) - 48 >=10){
                try{
                    answer.replace(answer.charAt(j-1),(char) (answer.charAt(j-1)+1));
                }catch(Exception e){
                    extra++;
                }
            }
            if(extra==0){
                answer += ray.get(0).charAt(j) - 48 + ray.get(1).charAt(j) - 48 + "";
            }
            else {
                answer += extra + "" + (ray.get(0).charAt(j) - 48 + ray.get(1).charAt(j) - 48) + "";
            }
        }
        answer=addNums(answer, 0, ray, j+1,n);
        return(answer);
    }
}