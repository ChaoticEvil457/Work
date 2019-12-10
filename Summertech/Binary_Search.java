package Summertech;

import java.util.Arrays;
import java.util.Scanner;

public class Binary_Search {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int ray[] = new int[100];
        for (int i = 0; i < ray.length - 1; i++) {
            int j = (int) (Math.random() * 99)+1;
            for (int k = 0; k < ray.length - 1; k++) {
                if (ray[j] == k) {
                    j = (int) (Math.random() * 99) + 1;
                    k = 0;
                }
            }
            ray[i] = j;
        }
        Arrays.sort(ray);
        System.out.println("Input a number from 1 to 99");
        int number = scan.nextInt();
        int output = finder(number, ray, 0, ray.length - 1);
        if (output == -1) {
            System.out.println(number + " does not appear in the array.");
        } else {
            System.out.print(number + " is at position ");
            System.out.println(output);
        }
        for(int i=0;i<ray.length-2;i++){
            System.out.print(ray[i]+ ", ");
        }
        System.out.println(ray[ray.length-1]);
    }

    public static int finder(int number, int ray[], int min, int max) {
        int mid = (max + min) / 2;
        if (max == min) {
            return (-1);
        }
        if (ray[mid] > number) {
            return (finder(number, ray, min, mid-1));
        } else if (ray[mid] < number) {
            return (finder(number, ray, mid+1, max));
        }
        return (mid);
    }
}