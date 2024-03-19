import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class HW4 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner s2 = new Scanner(System.in);
        System.out.println("Enter the size of the matrix in the file");
        int size = s2.nextInt();// user inputs the size of the matrix

        double[][] ray = new double[size][size];
        System.out.println("Enter the file name");
        File f = new File(s2.next());// user inputs a file name
        Scanner scan = new Scanner(f);

        for (int i = 0; i < size; i++) {// fills list with file data
            for (int j = 0; j < size; j++) {
                if (scan.hasNextDouble()) {
                    ray[i][j] = scan.nextDouble();
                }
            }
        }

        printAnswer(BetterForwardElimination(ray));
        scan.close();
    }

    public static void printAnswer(double[][] ray) {// prints and formats the answer
        for (int i = 0; i < ray.length - 1; i++) {
            System.out.printf("%5.2f x%d = %5.2f\n", ray[i][i], i + 1, ray[i][ray.length - 1]);
        }
    }

    /**
     * Performs Gauss Jordan Elimination on a given matrix
     * 
     * @param ray given matrix
     * @return returns a matrix in reduced row echelon form
     */
    public static double[][] BetterForwardElimination(double[][] ray) {
        for (int i = 0; i < ray.length - 2; i++) {
            int pivot = i;// stores pivot row
            for (int j = i + 1; j < ray.length - 1; j++) {
                if (Math.abs(ray[j][i]) > Math.abs(ray[pivot][i])) {
                    pivot = j;// pivot row moves
                }
                for (int k = i; k < ray.length; k++) {
                    double temp = ray[i][k];// move the currently remembered pivot row (largest pivot value) to the top
                    ray[i][k] = ray[pivot][k];
                    ray[pivot][k] = temp;
                }
            }
            if (ray[i][i] != 0) {// skips if there are no possible pivots
                for (int j = i + 1; j < ray.length - 1; j++) {
                    double temp = ray[j][i] / ray[i][i];
                    for (int k = i; k < ray.length; k++) {
                        ray[j][k] = ray[j][k] - ray[i][k] * temp;// row reduces
                    }
                }
            }
        }

        for (int i = ray.length - 1; i >= 0; i--) {// converts row echelon to reduced row echelon
            if (ray[i][i] != 0) {
                for (int j = i - 1; j >= 0; j--) {
                    double temp = ray[j][i] / ray[i][i];
                    for (int k = ray.length - 1; k >= i; k--) {
                        ray[j][k] = ray[j][k] - ray[i][k] * temp;// further reduces
                    }
                }
            }
        }

        return ray;
    }

}