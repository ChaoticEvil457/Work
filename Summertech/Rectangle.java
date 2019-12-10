package Summertech;

public class Rectangle {

	private int height;
	private int width;
	
	public Rectangle(int height,int width){
		this.height=height;
		this.width=width;
	}
	public int getHeight(){
		return height;
	}
	public int getWidth(){
		return width;
	}
	public void setHeight(int height){
		this.height=height;
	}
	public void setWidth(int width){
		this.width=width;
	}
	public int getArea(){
		return this.height * this.width;
	}
	public int getPerimeter(){
		return this.height + this.height + this.width + this.width;
	}
}
