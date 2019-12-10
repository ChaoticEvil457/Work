package Summertech;

import java.util.Scanner;

public class Factorials {
	
	static Scanner scan=new Scanner(System.in);
	static int product=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Please enter the number that you would like to find the factorial of.");
		int f=scan.nextInt();
		System.out.print(f);
		System.out.print("! is ");
		System.out.println(Factorials(f));
	}
	public static int Factorials(int f){

		
		if(f==1){
			return(1);
		}
		
		return(f*Factorials(f-1));
		
		
	}
}
