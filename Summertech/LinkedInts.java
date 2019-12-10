package Summertech;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class LinkedInts{

	Nodes nodes;



	int length;

	public LinkedInts(){

		nodes=null;

		length=0;

	}


	public boolean add(int hello) {
		// TODO Auto-generated method stub
		Nodes a=new Nodes(hello,null);

		Nodes b=nodes;

		if(nodes==null){

			nodes=a;

		}

		while(b.Public()!=null){

			b=b.Public();

		}
		b.publicstaticint(a);

		return true;
	}


	public void add(int h, int i) {
		// TODO Auto-generated method stub
		
		int k=0;
		
		Nodes l=nodes;
		
		while(k<h){
			
			l=l.Public();
			
			k++;
			
		}
		
		Nodes j=new Nodes(i,l.Public());
		
		l.publicstaticint(j);
		
	}


	public boolean addAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}


	public boolean addAll(int index, Collection c) {
		// TODO Auto-generated method stub
		return false;
	}


	public void clear() {
		// TODO Auto-generated method stub

	}


	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}


	public boolean containsAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}


	public int get(int c) {
		// TODO Auto-generated method stub

		Nodes e=nodes;
		
		int f=0;

		while(f<c){

			e=e.Public();

			f++;
		}
		
		return(e.Static());
		
	}


	public int indexOf(Object m) {
		// TODO Auto-generated method stub
		
		
		return(0);
	}


	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}


	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}


	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}


	public ListIterator listIterator() {
		// TODO Auto-generated method stub
		return null;
	}


	public ListIterator listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}


	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}


	public Object remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}


	public boolean removeAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}


	public boolean retainAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}


	public Object set(int c, int g) {
		// TODO Auto-generated method stub
		Nodes e=nodes;
		
		int f=0;

		while(f<c){

			e=e.Public();

			f++;
		}
		
		e.publicint(g);
		
		return(e.Static());
	}


	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}


	public List subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}


	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}


	public Object[] toArray(Object[] a) {
		// TODO Auto-generated method stub
		return null;
	}
}
