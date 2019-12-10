package Summertech;

import java.util.Scanner;
public class paladrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner Scanner=new Scanner(System.in);
		String String=("");
		String String1=("");
		String String2=("");
		String=Scanner.nextLine();
		for(Integer Integer=String.length();Integer>0;Integer--){
			if((String.substring(Integer-1,Integer).matches("[a-zA-Z_0-9]"))){
		String1+=String.substring(Integer-1,Integer);
			}

		}
		for(int bbh=0;bbh<String.length();bbh++){
			if(String.substring(bbh,bbh+1).matches("[a-zA-Z_0-9]")){
		String2+=String.substring(bbh,bbh+1);
			}
			
		}
		System.out.println(String1);
		if(String1.equalsIgnoreCase (String2)){
			System.out.println("This is a palindrome");
		}
		if(!String1.equalsIgnoreCase (String2)){
			System.out.println("This is not a palindrome");
		}
		Scanner.close();
	}

}
