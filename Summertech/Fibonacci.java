package Summertech;

import java.util.Scanner;

public class Fibonacci {
	
	static Scanner scan = new Scanner(System.in);
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x=0;
		int y=1;	
		int counter=0;
		System.out.println("Enter in the number of didgits you want to generate of the Fibonacci Sequence.");
		
		int v=scan.nextInt();
		
		System.out.println("The Fibonacci Sequence goes like this:");
		Calculate(x,y,v,counter);
	}
	
	public static int Calculate(int x, int y, int v, int counter){
		
		int z=0;

		counter++;
		System.out.println(x);
		
		z=y;
		
		y=x+y;
		
		x=z;
		
		if(counter>=v){
			return(1);
		}
		
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return(Calculate(x,y,v,counter));
		
	}

}
