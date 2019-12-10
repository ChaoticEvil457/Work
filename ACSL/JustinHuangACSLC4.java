package ACSL;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class JustinHuangACSLC4 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("4int-sameple data.txt"));
        while (scan.hasNext()) {
            ArrayList<String> ray = new ArrayList<String>();
            ArrayList<Integer> fin = new ArrayList<Integer>();
            Scanner line = new Scanner(scan.nextLine());
            while (line.hasNext()) {
                ray.add(line.next());
            }
            System.out.println(ray);
            System.out.println(fin);
            for (int i = ray.size() - 1; i >= 0; i--) {
                if ((ray.get(i).charAt(0) >= 48 && ray.get(i).charAt(0) <= 57)) {
                    fin.add(((int) ray.get(i).charAt(0)) - 48);
                } else {
                    if (ray.get(i).equals("@")) {
                        if (fin.get(fin.size() - 1) > 0) {
                            fin.remove(fin.size() - 3);
                            fin.remove(fin.size() - 1);
                        } else {
                            fin.remove(fin.size() - 1);
                            fin.remove(fin.size() - 1);
                        }
                    } else if (ray.get(i).equals(">")) {
                        if (fin.get(fin.size() - 2) > fin.get(fin.size() - 1)&&fin.get(fin.size() - 2) > fin.get(fin.size() - 3)) {
                            fin.remove(fin.get(fin.size() - 1));
                            fin.remove(fin.get(fin.size() - 2));
                        } else if(fin.get(fin.size() - 1) > fin.get(fin.size() - 2)&&fin.get(fin.size() - 1) > fin.get(fin.size() - 3)){
                            fin.remove(fin.get(fin.size() - 2));
                            fin.remove(fin.get(fin.size() - 2));
                        }
                        else{
                            fin.remove(fin.get(fin.size() - 1));
                            fin.remove(fin.get(fin.size() - 1));
                        }
                    }
                    else {
                        int var = function(ray.get(i), fin);
                        fin.remove(fin.size() - 1);
                        fin.set(fin.size() - 1, var);
                    }
                }
                ray.remove(ray.size() - 1);
            }
            System.out.println(fin);
            line.close();
        }
        scan.close();
    }

    public static int function(String s, ArrayList<Integer> fin) {
        if (s.equals("/")) {
            return (fin.get(fin.size() - 1) / fin.get(fin.size() - 2));
        } else if (s.equals("*")) {
            return (fin.get(fin.size() - 1) * fin.get(fin.size() - 2));
        } else if (s.equals("+")) {
            return (fin.get(fin.size() - 1) + fin.get(fin.size() - 2));
        }
        return (fin.get(fin.size() - 1) - fin.get(fin.size() - 2));
    }
}
