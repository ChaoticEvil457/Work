import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Match {
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        try ( // Create an input stream for file object.dat
                ObjectInputStream mainmaster = new ObjectInputStream(new FileInputStream("mainmaster.ser"));) {


        }
    }

}
