package Summertech;

import java.util.Scanner;

public class Hanoi {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int Destination=3;
		
		int Spare=2;
		
		int Pos=1;
		
		int diskMove=0;
		
		System.out.println("How many disks do you have in your towers of hanoi game?");

		int disks=scan.nextInt();
		
		int ray[]=new int[disks];
		
		int z=0;
		
		int diskNum=disks;
		
		while(z<disks){

		ray[z]=1;

		z++;
		
		}
		
		towers(Destination,Spare,diskNum,diskMove,ray,Pos);

	}

	public static int towers(int Destination,int Spare,int diskNum,int diskMove,int ray[],int pos){
		
		if(diskNum-1==diskMove){
			
			ray[diskNum-1]=Destination;
			
			System.out.print("Move disk ");
			
			System.out.print(diskMove);
			
			System.out.print(" to position ");
			
			System.out.println(Destination);
		}
		else{
			
			towers(Spare,Destination,diskNum,diskMove+1,ray,pos);
			
			ray[diskMove]=Destination;
			
			System.out.print("Move disk ");
			
			System.out.print(diskMove);
			
			System.out.print(" to position ");
			
			System.out.println(Destination);
			
			towers(Destination,pos,diskNum,diskMove+1,ray,Spare);
			

			
			
		}
		
		
		
		
		return(1);

	}
}