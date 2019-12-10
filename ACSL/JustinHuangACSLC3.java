package ACSL;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class JustinHuangACSLC3 {
    public static int startx = 0;
    public static int starty = 0;

    public static void main(String args[]) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("3int-sampledata.txt"));
        while (scan.hasNext()) {
            String letters = "";
            int rows = scan.nextInt();
            int columns = scan.nextInt();
            int[][] ray = new int[rows][columns];
            startx = scan.nextInt();
            int initial = startx;
            starty = startx / 10;
            startx = startx % columns;
            if (startx != 0) {
                startx--;
            }
            int qwe = scan.nextInt();
            for (int i = 0; i < qwe; i++) {
                int x = scan.nextInt();
                int y = x / 10;
                x = x % columns - 1;
                try {
                    ray[y][x] = 1;
                }catch(Exception e){
                    ray[y-2][x] = 1;
                    starty-=2;
                }
            }
            printRay(ray);
            boolean end = false;
            if (rows*columns!=initial) {
                while (!end) {
                    try {
                        if (ray[starty][startx] == 0 && ray[starty][startx + 1] == 0 && ray[starty][startx + 2] == 0) {
                            ray = block(ray, "a");
                            letters += "A";
                        }
                    } catch (Exception e) {
                        if (startx == columns) {
                            end = true;
                        }
                    }
                    try {
                        if (ray[starty][startx] == 0 && ray[starty + 1][startx] == 0 && ray[starty + 1][startx + 1] == 0) {
                            ray = block(ray, "b");
                            letters += "B";
                        }
                    } catch (Exception e) {
                        if (startx == columns) {
                            end = true;
                        }
                    }
                    try {
                        if (ray[starty][startx] == 0 && ray[starty][startx + 1] == 0 && ray[starty + 1][startx + 1] == 0 && ray[starty + 2][startx + 1] == 0) {
                            ray = block(ray, "c");
                            letters += "C";
                        }
                    } catch (Exception e) {
                        if (startx == columns) {
                            end = true;
                        }
                    }
                }
                printRay(ray);
                System.out.println(letters);
            } else {
                startx=columns-1;
                starty--;
                while (!end) {
                    try {
                        if (ray[starty][startx] == 0 && ray[starty][startx - 1] == 0 && ray[starty][startx - 2] == 0) {
                            ray = revblock(ray, "a");
                            letters += "A";
                        }
                    } catch (Exception e) {
                        if (startx == -1) {
                            end = true;
                        }
                    }
                    try {
                        if (ray[starty][startx] == 0 && ray[starty][startx - 1] == 0 && ray[starty - 1][startx - 1] == 0) {
                            ray = revblock(ray, "b");
                            letters += "B";
                        }
                    } catch (Exception e) {
                        if (startx == -1) {
                            end = true;
                        }
                    }
                    try {
                        if (ray[starty][startx] == 0 && ray[starty - 1][startx] == 0 && ray[starty - 2][startx] == 0 && ray[starty - 2][startx - 1] == 0) {
                            ray = revblock(ray, "c");
                            letters += "C";
                        }
                    } catch (Exception e) {
                        if (startx == -1) {
                            end = true;
                        }
                    }
                }
                printRay(ray);
                String nletters = "";
                for (int i = letters.length()-1; i >= 0; i--) {
                    nletters += letters.charAt(i);
                }
                System.out.println(nletters);
            }

        }
        scan.close();
    }

    public static void printRay(int[][] ray) {
        System.out.println();
        System.out.println();
        for (int i = 0; i < ray.length; i++) {
            for (int j = 0; j < ray[0].length; j++) {
                System.out.print(ray[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] block(int[][] ray, String blockType) {
        if (blockType == "a") {
            ray[starty][startx] = 1;
            ray[starty][startx + 1] = 1;
            ray[starty][startx + 2] = 1;
            startx += 3;
        }
        if (blockType == "b") {
            ray[starty][startx] = 1;
            ray[starty + 1][startx] = 1;
            ray[starty + 1][startx + 1] = 1;
            startx += 2;
            starty += 1;
        }
        if (blockType == "c") {
            ray[starty][startx] = 1;
            ray[starty][startx + 1] = 1;
            ray[starty + 1][startx + 1] = 1;
            ray[starty + 2][startx + 1] = 1;
            startx += 2;
            starty += 2;
        }
        return (ray);
    }

    public static int[][] revblock(int[][] ray, String blockType) {
        if (blockType == "a") {
            ray[starty][startx] = 1;
            ray[starty][startx - 1] = 1;
            ray[starty][startx - 2] = 1;
            startx -= 3;
        }
        if (blockType == "b") {
            ray[starty][startx] = 1;
            ray[starty][startx - 1] = 1;
            ray[starty - 1][startx - 1] = 1;
            startx -= 2;
            starty -= 1;
        }
        if (blockType == "c") {
            ray[starty][startx] = 1;
            ray[starty - 1][startx] = 1;
            ray[starty - 2][startx] = 1;
            ray[starty - 2][startx - 1] = 1;
            startx -= 2;
            starty -= 2;
        }
        return (ray);
    }
}
