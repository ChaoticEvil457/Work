
// CreateSequentialFile.java
// Writing objects sequentially to a file with class ObjectOutputStream.
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.NoSuchElementException;


import java.util.*;

public class CreateSequentialFile1 {
	// private static ObjectOutputStream output; // outputs data to file

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.printf("%s%n%s%n? ", "Enter account number, first name, last name and balance.",
				"Enter end-of-file indicator to end input.");

		try (ObjectOutputStream output = new ObjectOutputStream(Files.newOutputStream(Paths.get("clients.ser")))) {

			while (input.hasNext()) // loop until end-of-file indicator
			{
				try {

					// create new record; this example assumes valid input
					Account2 record = new Account2(input.nextInt(), input.next(), input.next(), input.nextDouble());

					// serialize record object into file
					output.writeObject(record);
				} catch (NoSuchElementException elementException) {
					System.err.println("Invalid input. Please try again.");
					input.nextLine(); // discard input so user can try again
				}

				System.out.print("? ");
			}

		} catch (IOException ioException) {
			System.err.println("Error writing to file. Terminating.");
			// break;

		}

	}

}
