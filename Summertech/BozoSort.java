package Summertech;

public class BozoSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] ray={4,1,5,2,3,76,346,253};

		int z=0;
		int g=0;
		int f=0;
		int l=0;
		int counter=-1;
		
		while(counter<ray.length){
			
			int x=(int) (Math.random()*ray.length);
			
			int y=(int) (Math.random()*ray.length);
			if(z+1>=ray.length){
				z=0;
			}

			if(ray[z]>ray[z+1]){
				
				f=ray[x];
				g=ray[y];
				
				ray[x]=g;
				ray[y]=f;
				
				counter=-1;
				z++;
				
			}
			else{
				z++;
				counter++;
			}
			if(z+1>=ray.length){
				z=0;
			}
			
			l++;
			System.out.println(l);
			
		}
		l=0;
		while(l<ray.length){
			
		System.out.print(ray[l]);
		System.out.print(",");
		
		l++;
		
		}

	}

}
