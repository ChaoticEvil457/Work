package Summertech;

import java.util.Scanner;

public class Skadooks {
	public static String Int=("");
	public static String Double=("");
	public static String Boolean=("");
	public static Integer Integer=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner Scanner=new Scanner(System.in);
	Double=Scanner.nextLine();
		reverse(Double,Double.length());
		System.out.println(Int);
		if(Double.equals(Int)){
			System.out.println("This is a palidrome");
		}
		if(!Double.equals(Int)){
			System.out.println("This is not a palidrome");
		}
		Scanner.close();
	}
	public static String reverse(String String, Integer Integer){
		if(String.length()==1){
			return String;
		}
		Int+=(String.substring(Integer-1,Integer));
		reverse(String.substring(0,Integer),Integer-1);
		return "";

	}
}