package Summertech;
import java.util.LinkedList;

public class HashMap{

	private LinkedList<Pear>[] ray=new LinkedList[16];

	public HashMap(){

		for(int a=0;a<ray.length;a++){

			ray[a]=new LinkedList();

		}
	}

	public int hash(Object key){

		int out=key.hashCode();

		return(Math.abs(out)%ray.length);
	}


	public void add(Object key, Object value){

		int n;

		n=hash(key);

		ray[n].add(new Pear(key,value));

	}

	public Object get(Object key){

		int n=hash(key);

		for(int i=0;i<ray[n].size();i++){
			if((ray[n].get(i)).getKey().equals(key)){

				return((ray[n].get(i)).getValue());
			}

		}
		return(ray[n]);
	}

	public void remove(Object key){
		int n=hash(key);

		for(int a=0;a<ray[n].size();a++){

			if(ray[n].get(a).getKey().equals(key)){
				
				ray[n].remove(a);
				return;
			}
			
		}
	}

	
	public void resize(){ 

		LinkedList<Pear>[] ray2=new LinkedList[ray.length*2];
		LinkedList<Pear>[] tempray=new LinkedList[ray.length];
		
		
		for(int a=0;a<=ray.length;a++){

			tempray[a]=ray[a];

		}

		ray=ray2;

		for(int b=0;b<=ray.length;b++){
			for(int c=0;c<=ray[b].size();c++){
				
				add(tempray[b].get(c).getKey(),tempray[b].get(c).getValue());

			}
		}
	}
}
