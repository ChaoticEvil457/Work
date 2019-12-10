package Summertech;

public class Bubbles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int x=0;
		int y=1;
		int z=0;
		int c=0;
		int j=0;
		int k=0;

		int track=0;
		int ray[]={2134123,132143,23423,214,3243,3242,3241,1234123,51423242};

		
		long time=System.currentTimeMillis();
		counter(ray,x,y,track,z,c,j);
		while(k<ray.length){
		System.out.println(ray[k]);
		k++;
		}
		System.out.println((System.currentTimeMillis()-time));
	}

	public static int counter(int ray[], int x, int y, int track,int z, int c,int j){
		try{
			if(ray[x]>ray[y]){

				z=ray[x];
				c=ray[y];
				ray[y]=z;
				ray[x]=c;
				x++;
				y++;
				j=0;

			}
			else{
				j++;
				x++;
				y++;
			}
			if(j==ray.length){
			return(1);	
			}
		}

		catch(Exception e){
			y=1;
			x=0;
		}


		return(counter(ray,x,y,track,z,c,j));

	}

}
