package Summertech;

import java.util.Scanner;

public class Arrayss {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner=new Scanner(System.in);
		String [][] x=new String[3][3];


		for(int i=0;i<3;i++){
			for(int o=0;o<3;o++){
				x[i][o]=" -";
			}
		}

		print(x);
		
		int j=0;
		int k=0;
		
		int h=0;
		while(h==0){
			
			int mb =0;
			while(mb==0){
			    j=scanner.nextInt();
				k=scanner.nextInt();
			if(x[j][k].equals(" -")){
			x[j][k]= " x";
			break;
			}
			else{
				System.out.println("Sorry, that space is taken");
			}
			scanner.close();
		}
			//---------------------------//
			
			print(x);
			
			for(int q=0;q<3;q++ ){

				if(x[q][0].equals(x[q][1])&& x[q][1].equals(x[q][2])&& x[q][0].equals(" x")){
					System.out.println("X wins");
					System.exit(0);
				}



				if(x[0][q].equals(x[1][q])&& x[1][q].equals(x[2][q])&& x[0][q].equals(" x")){
					System.out.println("X wins");
					System.exit(0);
				}
			}


			if(x[0][0].equals(x[1][1])&& x[1][1].equals(x[2][2])&&x[0][0].equals(" x")){
				System.out.println("X wins");
				System.exit(0);
			}

			int n=0;
			int m=0;
			int kl =0;
			while(kl==0){
			    n=scanner.nextInt();
				m=scanner.nextInt();
			if(x[n][m].equals(" -")){
			x[n][m]= " o";
			break;
			}
			else{
				System.out.println("Sorry, that space is taken");
			}
		}
			//---------------------------//

			if(x[n][m].equals(" -")){
				x[n][m]= " o";
				}


			print(x);
			
			
			for(int r=0;r<3;r++ ){

				if(x[r][0].equals(x[r][1])&& x[r][1].equals(x[r][2])&& x[r][0].equals(" o")){
					System.out.println("O wins");
					System.exit(0);
				}

				if(x[0][r].equals(x[1][r])&& x[1][r].equals(x[2][r])&& x[0][r].equals(" o")){
					System.out.println("O wins");
					System.exit(0);
				}



				if(x[0][0].equals(x[1][1])&& x[1][1].equals(x[2][2])&&x[0][0].equals(" o")){
					System.out.println("O wins");
					System.exit(0);
				}
			}
			
		}
	}
	//---------------------------------//
	public static void print(String[][] board){
		for(int y=0;y<3;y++){

			for(int z=0;z<3;z++){
				System.out.print(board[y][z]);
			}
			System.out.println();

		}

		
	}
	//-----------------------------//
}

