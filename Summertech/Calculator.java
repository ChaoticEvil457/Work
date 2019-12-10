package Summertech;

import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
		// TODO Auto-generated method 


		Scanner scan=new Scanner(System.in);
		System.out.println("Enter Your Operation");
		String op=scan.next();
		if(op.equals("+")){
			System.out.println("Enter your two numbers");
			int x = scan.nextInt();
			int y = scan.nextInt();
			System.out.println(add(x,y));
		}
		
		if(op.equals("*")){
			System.out.println("Enter your two numbers");
			int a = scan.nextInt();
			int s = scan.nextInt();
			System.out.println(multiply(a,s));
		}
		
		if(op.equals("/")){
			System.out.println("Enter your two numbers");
			int d = scan.nextInt();
			int f = scan.nextInt();
			System.out.println(divide(d,f));
		}
		
		if(op.equals("-")){
			System.out.println("Enter your two numbers");
			int g = scan.nextInt();
			int h = scan.nextInt();
			System.out.println(subtract(g,h));
		}
		


	}
	public static int add(int x,int y){
		return x+y;
	}
	public static int multiply(int a,int s){
		return a*s;
	}
	public static int divide(int d,int f){
		return d/f;
	}
	public static int subtract(int g,int h){
		return g-h;
	}
}
