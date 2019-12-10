package Summertech;

public class Square extends Rectangle{
	
	public Square(int width){
		super(width,width);
		
	}
	public void setHeight(int height){
		super.setWidth(height);
		super.setHeight(height);
	}
	public void setWidth(int width){
		super.setWidth(width);
		super.setHeight(width);
	}
}