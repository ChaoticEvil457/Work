package Feb15;

import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class ReplaceTextPaths {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("sourceFile targetFile oldString newString, don't put .txt");
        System.out.println("Please input your source file (default source.txt)");
        String input = scan.next();
        Path sourceFile = Paths.get(input);

        if (!Files.exists(sourceFile)) {
            sourceFile = Paths.get("source.txt");
            System.out.println("The default file source.txt has been selected");
        }

        System.out.println("Please input your target file");
        input = scan.next();
        Path targetFile = Paths.get(input);
        if (Files.exists(targetFile)) {
            System.out.println("Target file already exists. Would you still like to use " + input + "?");
            input = scan.next();
            if (!input.equalsIgnoreCase("y") && !input.equalsIgnoreCase("yes")) {
                System.exit(2);
            }
        }
        System.out.println("Input the string you want to replace");
        String oldString = scan.next();
        System.out.println("What would you like to replace it with?");
        String newString = scan.next();
        scan.close();

        PrintWriter output = new PrintWriter(targetFile.toFile());
        Scanner read = new Scanner(sourceFile);
        while (read.hasNext()) {
            output.println(read.nextLine().replaceAll(oldString, newString));
        }
        output.close();
        read.close();
    }
}
