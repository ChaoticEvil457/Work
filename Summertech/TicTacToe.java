package Summertech;

import java.util.Scanner;

public class TicTacToe {
	public static void main(String[] args) {

		boolean Boolean = false;
		String[][] arrayz= new String[3][3];
		Scanner Scanner=new Scanner(System.in);
		/////////////////////////////////////////////////////////
		for(int z=0;z<arrayz.length;z++){
			for(int y=0;y<arrayz.length;y++){
				arrayz[z][y]=" *";
				/////////////////////////////////////////////////////////
			}
		}
		boolean l=false;
		while(l==false){
			printboard(arrayz);

			System.out.println("Enter your coordinates in Y,X format from 0 to 2");

			if(Boolean==true){
				System.out.println("It's X's turn");
			}
			if(Boolean==false){
				System.out.println("It's O's turn");
			}

			int q = Scanner.nextInt();
			int w = Scanner.nextInt();
			if(Boolean == false){
				if(arrayz[q][w]!=" *"){
					System.out.println("Sorry that is not a valid space");
				}
				else{
					arrayz[q][w]=" O";
					Boolean=true;
				}
			}
			else if(Boolean == true){
				if(arrayz[q][w]!=" *"){
					System.out.println("Sorry that is not a valid space");
				}
				else{
					arrayz[q][w]=" X";
					Boolean=false;
				}
			}
			if(wino(arrayz)==true){
				printboard(arrayz);
				System.exit(0);
			}
			if(winx(arrayz)==true){
				printboard(arrayz);
				System.exit(0);
			}
		}
		Scanner.close();
	}
	/////////////////////////////////////////////////////////
	public static void printboard(String[][] arrayz){
		/////////////////////////////////////////////////////////
		for(int x=0;x<arrayz.length;x++){
			for(int d=0;d<arrayz.length;d++){
				System.out.print(arrayz[x][d]);
			}
			System.out.println("");
		}
		/////////////////////////////////////////////////////////
	}
	public static boolean wino(String[][] arrayz){
		for(int i=0;i<3;i++){
			if(arrayz[0][i].equals(" O") && arrayz[1][i].equals(" O") && arrayz[2][i].equals(" O")){
				System.out.println("O wins!!!");
				return true;
			}
			if(arrayz[i][0].equals(" O") && arrayz[i][1].equals(" O") && arrayz[i][2].equals(" O")){
				System.out.println("O wins!!!");
				return true;
			}
		}
		if(arrayz[0][0].equals(" O") && arrayz[1][1].equals(" O") && arrayz[2][2].equals(" O")){
			System.out.println("O wins!!!");
			return true;
		}
		if(arrayz[2][0].equals(" O") && arrayz[1][1].equals(" O") && arrayz[0][2].equals(" O")){
			System.out.println("O wins!!!");
			return true;
		}
		return false;
	}
	public static boolean winx(String[][] arrayz){
		for(int i=0;i<3;i++){
			if(arrayz[0][i].equals(" X") && arrayz[1][i].equals(" X") && arrayz[2][i].equals(" X")){
				System.out.println("X wins!!!");
				return true;
			}
			if(arrayz[i][0].equals(" X") && arrayz[i][1].equals(" X") && arrayz[i][2].equals(" X")){
				System.out.println("X wins!!!");
				return true;
			}
		}
		if(arrayz[0][0].equals(" X") && arrayz[1][1].equals(" X") && arrayz[2][2].equals(" X")){
			System.out.println("X wins!!!");
			return true;
		}
		if(arrayz[2][0].equals(" X") && arrayz[1][1].equals(" X") && arrayz[0][2].equals(" X")){
			System.out.println("X wins!!!");
			return true;
		}
		return false;
	}
}