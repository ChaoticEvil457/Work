package Feb15;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class ReplaceText {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("sourceFile targetFile oldString newString, don't put .txt");
        File sourceFile = new File(scan.next() + ".txt");
        File targetFile = new File(scan.next() + ".txt");
        String oldString = scan.next();
        String newString = scan.next();
        scan.close();

        if (!sourceFile.exists()) {
            System.out.println("Source file is invalid");
            System.exit(0);
        }
        if (targetFile.exists()) {
            System.out.println("Target file already exists");
            System.exit(0);
        }
        PrintWriter output = new PrintWriter(targetFile);
        Scanner read = new Scanner(sourceFile);
        while (read.hasNext()) {
            output.println(read.nextLine().replaceAll(oldString, newString));
        }
        output.close();
        read.close();
    }
}
