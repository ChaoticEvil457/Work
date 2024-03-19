
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.NoSuchElementException;

public class StaffTest {
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        Employee[] staff = new Employee[5];
        staff[0] = new Employee("John Smith", 100.0, 10, 10, 10);
        staff[1] = new Manager("John Smith1", 100.0, 10, 10, 10);
        staff[2] = new Manager("John Smith2", 100.0, 10, 10, 10);
        staff[3] = new Employee("John Smith3", 100.0, 10, 10, 10);
        ((Manager) staff[1]).setSecretary(staff[3]);
        ((Manager) staff[2]).setSecretary(staff[3]);
        staff[3].raiseSalary(100);
        try (ObjectOutputStream output = new ObjectOutputStream(Files.newOutputStream(Paths.get("staff.ser")))) {

            for (Employee e : staff) {
                output.writeObject(e);
            }

        } catch (IOException ioException) {
            System.err.println("Error writing to file. Terminating.");
            // break;

        }
        try (ObjectInputStream input = new ObjectInputStream(Files.newInputStream(Paths.get("staff.ser")))) {
            while (true) // loop until end-of-file indicator
            {

                Employee staffs = (Employee) input.readObject();

                System.out.println(staffs);
            }

        } catch (EOFException endOfFileException) {
            System.err.printf("%nNo more records%n");
        }
    }
}
