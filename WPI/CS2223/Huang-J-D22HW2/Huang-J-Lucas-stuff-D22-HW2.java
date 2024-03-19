import java.util.Scanner;

class HuangJLucasstuffD22HW2 {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter the number of Lucas Numbers you want printed:");
        int n = scan.nextInt();
        long time = System.currentTimeMillis();

        for (int i = 0; i <= n; i++) {
            System.out.println(
                    "L(" + i + ") = " + findLucasNumbers(i) + " (" + (System.currentTimeMillis() - time)
                            + " milliseconds)");

            time = System.currentTimeMillis();
        }
        int j;
        long jTime = System.currentTimeMillis();
        int z;
        long zTime = System.currentTimeMillis();
        long temp;
        for (int i = 0; i <= n; i++) {
            System.out.println("Ratio between L(n+1) and L(n):");
            jTime = System.currentTimeMillis();
            j = findLucasNumbers(n);
            temp = System.currentTimeMillis() - jTime;
            zTime = System.currentTimeMillis();
            z = findLucasNumbers(n + 1);
            System.out.println(
                    (double) z / (double) j + " || " + (double) (System.currentTimeMillis() - zTime) / (double) temp);
        }
    }

    public static int findLucasNumbers(int n) {
        if (n == 0) {
            return 2;
        }
        if (n == 1) {
            return 1;
        }
        return findLucasNumbers(n - 2) + findLucasNumbers(n - 1);
    }
}

class MySeries {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Input the number of values of the series you would like to see");
        int n = scan.nextInt();
        for (int i = 0; i <= n; i++) {
            System.out.println("?(" + i + ") = " + findMySeries(i));
        }
        int j;
        long jTime = System.currentTimeMillis();
        int z;
        long zTime = System.currentTimeMillis();
        long temp;
        for (int i = 0; i <= n; i++) {
            System.out.println("Ratio between ?(n+1) and ?(n):");
            jTime = System.currentTimeMillis();
            j = findMySeries(n);
            temp = System.currentTimeMillis() - jTime;
            zTime = System.currentTimeMillis();
            z = findMySeries(n + 1);
            System.out.println(
                    (double) z / (double) j + " || " + (double) (System.currentTimeMillis() - zTime) / (double) temp);
        }
    }

    public static int findMySeries(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 2;
        }
        return (findMySeries(n - 1) - findMySeries(n - 2));
    }
}