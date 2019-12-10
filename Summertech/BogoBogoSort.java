package Summertech;

import java.util.ArrayList;
import java.util.Random;

public class BogoBogoSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		long time=System.currentTimeMillis();

		ArrayList<Integer> ray=new ArrayList<Integer>();

		ray.add(4);
		ray.add(3);
		ray.add(2);
		ray.add(1);
		ray.add(455);

		int count=0;

		System.out.println(ray);

		ray=sorter(ray,count);

		System.out.println(ray);

		System.out.println((System.currentTimeMillis()-time)/1000);

	}
	public static ArrayList<Integer> sorter(ArrayList<Integer> ray,int count){
		int f=0;
		Random rand=new Random();
		ArrayList<Integer> ray2=new ArrayList<Integer>();

		if(Sorted(ray)){

			return(ray);

		}
		else{ 

			f=0;

			while(ray.size()>0){

				int p=rand.nextInt(ray.size());

				f=ray.get(p);

				ray.remove(p);

				ray2.add(0,f);
			}
			count++;
			System.out.println(count);
		}		
		if(Sorted(ray2)){

			return(ray2);

		}
		else{
			ray2=sorter(ray2,count);

			for(int j=0;j<ray.size()-2;j++){
				for(int g=0;g<j;g++){
					if(ray.get(g)>ray.get(g)+1){
						sorter(ray,count);
					}
				}
			}	
		}


		return(ray2);
	}


	public static boolean Sorted(ArrayList<Integer> ray){

		int x=0;
		int counter=0;

		while(x+1<ray.size()){
			if(ray.get(x)>ray.get(x+1)){

				return(false);

			}
			else{
				counter++;
			}
			x++;
		}
		if(counter+1==ray.size()){

			return(true);

		}
		else{
			return(false);
		}

	}
}
