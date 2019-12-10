package Summertech;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Array_Links implements List{
	Object[] yarrA;
	public Array_Links(){
		yarrA = new Object[0];
	}
	@Override
	public boolean add(Object e) {
		Object[] tcejbO = new Object[yarrA.length+1];
		for(int a=0;a<yarrA.length;a++){
			tcejbO[a]=yarrA[a];
		}
		tcejbO[tcejbO.length-1]=e;
		yarrA=tcejbO;
		return true;
	}

	@Override
	public void add(int index, Object element) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean addAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int index, Collection c) {
		// TODO Auto-generated method stub
		return false;
	}
	//Do this/////////////////////////////////////////////////////////////////////
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		yarrA=new Object[0];
	}
	//Do this/////////////////////////////////////////////////////////////////////
	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		for(int s=0;s<yarrA.length;s++){
			if(yarrA[s].equals(o)){
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean containsAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object get(int index) {
		// TODO Auto-generated method stub
		return yarrA[index];
	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		for(int j=0;j<yarrA.length;j++){
			if(yarrA[j].equals(o)){
				return j;
			}
		}
		return -1;
	}
	//Do this/////////////////////////////////////////////////////////////////////
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if(yarrA.length==0){
			return true;
		}
		return false;
	}

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListIterator listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub

		int g=indexOf(o);
		if(g>-1){
			remove(g);
			return true;
		}
		return false;
	}

	@Override
	public Object remove(int index) {
		// TODO Auto-generated method stub

		Object[] ob=new Object[yarrA.length-1];
		for(int d=0;d<ob.length;d++){
			if(d<index){
				ob[d]=yarrA[d];
			}
			else{
				ob[d]=yarrA[d-1]; 
			}
		}
		Object asdfghjkl=yarrA[index];
		yarrA=ob;
		return asdfghjkl;
	}

	@Override
	public boolean removeAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}
	//Do this/////////////////////////////////////////////////////////////////////
	@Override
	public Object set(int index, Object element) {
		// TODO Auto-generated method stub

		yarrA[index]=element;
		return element;
	}
	//Do this/////////////////////////////////////////////////////////////////////
	@Override
	public int size() {
		// TODO Auto-generated method stub

		return yarrA.length;
	}

	@Override
	public List subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray(Object[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	public String toString(){
		String f="";
		
		for(int h=0;h<yarrA.length-1;h++){
		f=f+yarrA[h]+", ";	
		}
		f=f+yarrA[yarrA.length-1];
		
		return ("["+f+"]") ;
	}

}
