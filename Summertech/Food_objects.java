package Summertech;

import java.util.Scanner;

public class Food_objects {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		String x="";
		String y="";
		double z=0;

		Food food1=new Food();
		Food food2=new Food();
		Food food3=new Food();
		Food food4=new Food();
		Food food5=new Food();

		foodz(x,y,z,scanner,food1);
		foodz(x,y,z,scanner,food2);
		foodz(x,y,z,scanner,food3);
		foodz(x,y,z,scanner,food4);
		foodz(x,y,z,scanner,food5);
		System.out.println("");
		for(int r=0;r<1;r++){

			System.out.println(food1.getCategory()+" "+food1.getFood()+" $"+food1.getPrice());
			System.out.println(food2.getCategory()+" "+food2.getFood()+" $"+food2.getPrice());
			System.out.println(food3.getCategory()+" "+food3.getFood()+" $"+food3.getPrice());
			System.out.println(food4.getCategory()+" "+food4.getFood()+" $"+food4.getPrice());
			System.out.println(food5.getCategory()+" "+food5.getFood()+" $"+food5.getPrice());

		}
	}
	public static void foodz(String x,String y,double z, Scanner scanner,Food food1){
		System.out.println("Enter a food category (Fruit, Vegetable, Protein, Grain, Drink)");
		x=scanner.next();
		System.out.println("Now type out the name of the food you would like");
		y=scanner.next();
		System.out.println("Type in the price of your food");
		z=scanner.nextDouble();
		//food1=new Food(x,y,z);
		food1.foodCategory=x;
		food1.food=y;
		food1.foodPrice=z;
		System.out.println(food1.getCategory()+" "+food1.getFood()+" $"+food1.getPrice());
	}
}
