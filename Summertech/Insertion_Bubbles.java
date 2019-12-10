package Summertech;

import java.util.ArrayList;
import java.util.Arrays;

public class Insertion_Bubbles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Integer[] m={9,3,5,2,4,1};

		ArrayList<Integer> ray=new ArrayList<Integer>();

		ray.addAll(Arrays.asList(m));

		int y=0;

		System.out.println(ray);

		
		for(int c=0;c<ray.size()-1;c++){
			if(c>ray.size()){
				c=0;
			}
			while(ray.get(c)>ray.get(c+1)){

				y=ray.get(c);

				ray.remove(c);

				ray.add(c+1,y);
				try{
					while(ray.get(c-1)>ray.get(c)){

						y=ray.get(c);

						ray.remove(c);

						ray.add(c-1,y);
						c--;	
					}
				}
				catch(Exception e){}
				c++;
				System.out.println(ray);
			}
		}

	}
}