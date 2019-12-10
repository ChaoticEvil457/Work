package Summertech;

import java.util.Scanner;

public class Battle_Ship {
	static boolean z=true;
	static boolean c=true;
	static boolean v=true;
	static boolean b=true;
	static boolean n=true;

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		Scanner scanner=new Scanner(System.in);
		String [][] x=new String[11][11];
		String [][] y=new String[10][10];

		//for(int e=10;e<11;e++){
		//	for(int r=10;r<11;r++){
		//		x[e][r]="  0  1  2  3  4  5  6  7  8  9";
		//	}
		
		
		//}
		//print(x);


		for(int o=0;o<10;o++){
			for(int p=0;p<10;p++){
				x[o][p]="  ~";
			}
		}
		print(x);
		for(int i=0;i<10;i++){
			for(int l=0;l<10;l++){
				y[i][l]=" ";
			}
		}

		y[0][0]="x";
		y[0][1]="x";
		y[0][2]="x";
		y[2][3]="x";
		y[2][2]="x";
		y[2][4]="x";
		y[9][9]="x";
		y[8][8]="x";
		y[7][7]="x";
		y[9][0]="x";
		y[8][0]="x";
		y[7][0]="x";
		y[3][9]="x";
		y[2][8]="x";
		y[1][7]="x";
			boolean ship1=true;
			while(ship1){

				hitmiss(y,x,scanner);
				print(x);
				win(x);

			if(x[0][0].equals("  x")&& x[0][1].equals("  x")&& x[0][2].equals("  x")&& x[2][3].equals("  x")&& x[2][2].equals("  x")&& x[2][4].equals("  x")&& x[9][9].equals("  x")&& x[8][8].equals("  x")&& x[7][7].equals("  x")&& x[9][0].equals("  x")&& x[8][0].equals("  x")&& x[7][0].equals("  x")&& x[3][9].equals("  x")&& x[2][8].equals("  x")&& x[1][7].equals("  x")){
				System.out.println("YOU WIN!!!!!");
				ship1=false;
				System.exit(0);
			}
		}
	}
		//----------------------------------------//	
		
	//---------------------------------//
	public static void print(String[][] board){
		for(int y=0;y<10;y++){

			for(int z=0;z<10;z++){
				System.out.print(board[y][z]);
			}
			System.out.println();

		}

	}
	public static void hitmiss(String[][] ship,String[][] board1, Scanner scanner){
		System.out.println("Input your guess' coordinates");
		
		String x1=scanner.next();
		String y1=scanner.next();
		int x=0;
		int y=0;
		boolean flag = false;
		if(x1.equals("Justin Is Tired") || y1.equals("Justin Is Tired")){
			System.out.println("Yes He Is");
		}

		if((x1.equals("0")||x1.equals("1")||x1.equals("2")||x1.equals("3")||x1.equals("4")||x1.equals("5")||x1.equals("6")||x1.equals("7")||x1.equals("8")||x1.equals("9"))&&(y1.equals("0")||y1.equals("1")||y1.equals("2")||y1.equals("3")||y1.equals("4")||y1.equals("5")||y1.equals("6")||y1.equals("7")||y1.equals("8")||y1.equals("9"))){
			x=Integer.parseInt(x1);
			y=Integer.parseInt(y1);
			flag=true;
		}
		
		
		else{
				System.out.println("Sorry that isn't a valid space. Guess again");
			}
		
		 if(ship[x][y].equals("x")&& flag){
			System.out.println("HIT!!");
			board1[x][y]="  x";
		}
		else if(ship[x][y].equals(" ")&& flag){
			System.out.println("MISS!!");
			board1[x][y]="  o";
		}
		
			}
	public static void win(String[][] x){
			if(x[0][0].equals("  x")&&x[0][1].equals("  x")&&x[0][2].equals("  x")&&z){
				System.out.println("Ship Sunken");
				z=false;
			}
			if(x[2][3].equals("  x")&&x[2][2].equals("  x")&&x[2][4].equals("  x")&&c){
				System.out.println("Ship Sunken");
				c=false;
			}
			if(x[9][9].equals("  x")&&x[8][8].equals("  x")&&x[7][7].equals("  x")&&v){
				System.out.println("Ship Sunken");
				v=false;
			}
			if(x[9][0].equals("  x")&&x[8][0].equals("  x")&&x[7][0].equals("  x")&&b){
				System.out.println("Ship Sunken");
				b=false;
			}
			if(x[3][9].equals("  x")&&x[2][8].equals("  x")&&x[1][7].equals("  x")&&n){
				System.out.println("Ship Sunken");
				n=false;
			}
		}
	

	//----------------------------------------------//
}
