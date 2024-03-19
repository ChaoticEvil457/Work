
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;


public class ReadSequentialFile1 {
    public static void main(String[] args) throws ClassNotFoundException, IOException {

        try (ObjectInputStream input = new ObjectInputStream(Files.newInputStream(Paths.get("clients.ser")))) {
            while (true) // loop until end-of-file indicator
            {

                Account2 record = (Account2) input.readObject();

                System.out.printf("%-10d%-12s%-12s%,10.2f%n", record.getAccount(), record.getFirstName(),
                        record.getLastName(), record.getBalance());
            }

        } catch (EOFException endOfFileException) {
            System.err.printf("%nNo more records%n");
        }

    }
}
