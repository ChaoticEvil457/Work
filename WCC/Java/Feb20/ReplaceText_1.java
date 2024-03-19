import java.io.*;
import java.util.*;
import java.nio.file.*;

public class ReplaceText_1 {
  public static void main(String[] args) throws Exception {
        // Check if source file exists
   
    Path sourceFile =Paths.get("scores.txt");
    if (!Files.exists(sourceFile)){
          System.out.println("Source file  does not exist");
          System.exit(2);
    }

    // Check if target file exists
     File targetFile = new File ("targetf.txt");

  if (targetFile.exists()) {
      System.out.println("Target file already exists");
      System.exit(3);
    }
  try (
      // Create input and output files
     Scanner input = new Scanner(sourceFile);
     PrintWriter output = new PrintWriter(targetFile);
    ) {        
      while (input.hasNext()) {
        String s1 = input.nextLine();
        String s2 = s1.replaceAll("John", "Tom");
        output.println(s2);
      }
    }
  }
}
