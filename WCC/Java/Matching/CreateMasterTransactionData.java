
// Create data to put into an account file and a transactions file.
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;


public class CreateMasterTransactionData {
   private static ObjectOutputStream outOldMaster, outTransaction;

   public static void main(String[] args) {
      try {
         try {
            // file streams for output files
            outOldMaster = new ObjectOutputStream(
                  new FileOutputStream("mainmasterfile.ser"));
            outTransaction = new ObjectOutputStream(
                  new FileOutputStream("transactions.ser"));
         } catch (IOException io) {
            System.err.println("Error opening the file.");
         }

         try {
            outOldMaster.writeObject(new Account2(
                  100, "Alistair", "Smith", 300.00));
            outOldMaster.writeObject(new Account2(
                  300, "Susan", "Tom", 200.00));
            outOldMaster.writeObject(new Account2(
                  500, "Sherin", "Peter", 0.00));
            outOldMaster.writeObject(new Account2(
                  700, "Bill", "Samuel", 15.00));

            outTransaction.writeObject(
                  new Transaction(100, 50.00));
            outTransaction.writeObject(
                  new Transaction(300, 100.00));
            outTransaction.writeObject(
                  new Transaction(300, -10.00));
            outTransaction.writeObject(
                  new Transaction(400, 100.00));
            outTransaction.writeObject(
                  new Transaction(1400, 500.00));
         } catch (IOException io) {
            System.out.println("Error writing to the files.");
            System.exit(1);
         }
      } finally // close the files
      {
         try {
            if (outTransaction != null)
               outTransaction.close();

            if (outOldMaster != null)
               outOldMaster.close();
         } catch (IOException io) {
            System.err.println("Error closing the files.");
            System.exit(1);
         }
      }
   }
} // end class CreateData
