package Summertech;

import java.util.Scanner;

public class methods {

	public static void main(String[] args) {
		Scanner Scanner=new Scanner(System.in);
		int x = Scanner.nextInt();
		int y = Scanner.nextInt();
		System.out.println(add(x,y));
		Scanner.close();
	}
	public static int add(int x,int y){
		
		
		return x+y;
	}
}
