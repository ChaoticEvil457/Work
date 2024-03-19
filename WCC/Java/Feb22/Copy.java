
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Copy {
    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.out.println("not enough arguments");
            System.exit(1);
        }
        File sourceFile = new File(args[0]);
        File targetFile = new File(args[1]);
        if (!sourceFile.exists()) {
            System.out.println("Source file " + sourceFile + " does not exist");
            System.exit(2);
        }
        if (targetFile.exists()) {
            System.out.println("Target file " + targetFile + " already exists");
            System.exit(3);
        }
        try ( // Create an input stream for file temp.dat
                BufferedInputStream input = new BufferedInputStream(new FileInputStream(sourceFile));
                BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(targetFile));) {
            // Read student test scores from the file
            int curByte;
            int numBytes = 0;
            while ((curByte = input.read()) != -1) {
                output.write(curByte);
                numBytes++;
            }
            System.out.println("End of file reached");
            System.out.println(numBytes + " bytes copied");
        }
    }
}
