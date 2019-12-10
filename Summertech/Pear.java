package Summertech;
public class Pear {
	
	Object value;
	
	Object key;
	
	public Pear(Object k ,Object v){
		
		value=v;
		
		key=k;
		
	}
	
	public Object getValue(){
		
		return(value);
		
	}
	public Object getKey(){
		
		return(key);
		
	}	
	public Object setValue(Object v){

		value=v;

		return(v);

	}

	public Object setKey(Object k){

		key=k;

		return(k);

	}
	public String toString(){
		
		return(value.toString());
		
	}
}