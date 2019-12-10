package Summertech;

public class Int {

	Object[] ray;

	public Int(){

		ray=new Object[0];

	}

	public void add(Object s){

		int u=0;

		Object[] ray2=new Object[ray.length+1];

		while(u<ray.length){
			ray2[u]=ray[u];
			u++;
		}

		ray2[ray2.length-1]=s;

		ray=ray2;

	}

	public void remove(int s){

		int u=0;

		Object[] ray2=new Object[ray.length-1];

		while(u<ray.length){
			if(u!=s){
				ray2[u]=ray[u];
			}
			u++;
		}
		ray=ray2;
	}
	public Object get(int s){

		return(ray[s]);

	}

	public void add(int z,Object s){

		int u=0;
		int a=0;

		Object[] ray2=new Object[ray.length+1];

		while(u<ray.length){
			if(u==z){

				ray2[u]=s;
				a--;

			}
			else{
				ray2[u]=ray[a];
			}
			u++;
			a++;

		}

		ray=ray2;

	}

	public void clear(){

		ray=new Object[0];

	}

	public int size(){

		return(ray.length);

	}

	public boolean contains(Object s){
		int u=0;

		while(u<=ray.length){

			if(ray[u].equals(s)){

				return(true);
				
			}	

			u++;
		}
		return(false);
		
	}

	public Object indexOf(Object s){

		int u=0;

		while(u<=ray.length){

			if(ray[u].equals(s)){

				break;
			}

			u++;
		}

		return(u);
	}
}