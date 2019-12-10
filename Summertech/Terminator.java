package Summertech;

public class Terminator {

	private int height;
	private int weight;
	private int age;
	private String creator;
	private String material;
	private String name;

	public Terminator(int height1,int weight1,int age1,String creator1,String material1,String name1){
		height=height1;
		weight=weight1;
		age=age1;
		creator=creator1;
		material=material1;
		name=name1;
	}
	public int getHeight(){
		return height;
	}
	
	public int getAge(){
		return age;
	}
	public int getWeight(){
		return weight;
	}
	public String getCreator(){
		return creator;
	}
	public String getName(){
		return name;
	}
	public String getMaterial(){
	return material;
}
}
