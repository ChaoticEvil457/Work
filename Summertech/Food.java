package Summertech;

public class Food {
	public String foodCategory;
	public String food;
	public double foodPrice;


	public Food(String category,String food1,double foodPrice1){

		foodCategory=category;
		food=food1;
		foodPrice=foodPrice1;
	}
	public Food(){

	}

	public String getFood(){
		return food;
	}
	public String getCategory(){
		return foodCategory;
	}
	public double getPrice(){
		return foodPrice;
	}
}
