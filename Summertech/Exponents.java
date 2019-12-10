package Summertech;

import java.util.Scanner;

public class Exponents {

	static Scanner scan = new Scanner(System.in);
	
	static Scanner s=new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Input the number you want to multiply by itself.");
		
		int e=scan.nextInt();
		
		System.out.println("Input the number of times you want that number to be multiplied by itself.");
		
		int x=s.nextInt();
		
		System.out.println(Calculate(e,x));
		
		
	}
	
	public static int Calculate(int e,int x){
		
		
		if(x==0){
			return(1);
		}
		return(e*Calculate(e,x-1));
		
	}

}
