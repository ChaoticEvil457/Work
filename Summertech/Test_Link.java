package Summertech;

import java.util.ArrayList;

public class Test_Link{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Array_Links yarra=new Array_Links();
		yarra.add(3);
		yarra.add("asdf");
		yarra.add(3);
		yarra.add(3);
		yarra.add(3);
		yarra.add(8);
		yarra.add(3);
		yarra.add(3);
		yarra.add(3);
		yarra.add(3);
		System.out.println(yarra.get(2));
		System.out.println(yarra.size());
		yarra.set(7,3857894);
		/*System.out.println(yarra.get(0));  
		System.out.println(yarra.get(1));  
		System.out.println(yarra.get(2));  
		System.out.println(yarra.get(3));  
		System.out.println(yarra.get(4));
		System.out.println(yarra.get(5));  
		System.out.println(yarra.get(6));  
		System.out.println(yarra.get(7));  
		System.out.println(yarra.get(8));  
		System.out.println(yarra.get(9));  
		System.out.println(yarra.get(0));  
		System.out.println(yarra.indexOf(3));
		yarra.clear();
		System.out.println(yarra.isEmpty());
		*/
		ArrayList<Integer> list=new ArrayList<Integer>();
		list.add(1);
		list.add(34);
		list.add(3);
		System.out.println(list.toString());
		System.out.println(yarra.toString());
	}

}



