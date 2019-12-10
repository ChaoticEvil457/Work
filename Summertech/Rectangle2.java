package Summertech;

public class Rectangle2 {

	public static void main(String[] args) {
		
		Rectangle rect=new Rectangle(3,4);	
		
		Rectangle rect2=new Rectangle(3,5){
			 public int getPerimeter(){
				 return 0;
			 }
		};
		rect2.setWidth(7);
		System.out.println(rect.getPerimeter());
	}
}