package Summertech;

import java.util.ArrayList;

public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Integer> ray=new ArrayList<Integer>();

		ray.add(10);
		ray.add(20);
		ray.add(15);
		ray.add(12);
		ray.add(13);
		ray.add(11);
		ray.add(11);
		ray.add(12);
		ray.add(15);
		ray.add(10);
		ray.add(15);
		ray.add(15);
		long time=System.currentTimeMillis();
		ray = sorter(ray);
		System.out.println((System.currentTimeMillis()-time));
		System.out.println(ray);

	}

	public static ArrayList<Integer> sorter(ArrayList<Integer> ray){

		if(ray.size()<=1){
			return(ray);
		}

		int pivot=ray.get(ray.size()-1);

		for(int x=ray.size()-1;x>-1;x--){

			if(ray.get(x)>pivot){

				ray.add(ray.get(x));

				ray.remove(x);

			}

		}
		ArrayList<Integer> ray2=new ArrayList<Integer>();

		ArrayList<Integer> ray3=new ArrayList<Integer>();

		int l=0;

		while(l<ray.lastIndexOf(pivot)){

			ray2.add(ray.get(l));

			l++;

		}
		
		l=ray.lastIndexOf(pivot)+1;
		
		while(l<ray.size()){

			ray3.add(ray.get(l));
			
			l++;

		}

		ray2=sorter(ray2);
		ray3=sorter(ray3);

		ArrayList<Integer> ray4=new ArrayList<Integer>();

		ray4.addAll(ray2);
		ray4.add(pivot);
		ray4.addAll(ray3);

		return(ray4);

	}
}