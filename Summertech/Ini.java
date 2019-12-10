package Summertech;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.Scanner;
 
public class Ini {
 
    public static void main(String a[]){
        Map<String, Integer> map = new HashMap<String, Integer>();
        
        Scanner scan=new Scanner(System.in);
        
        int asdf=1;
        while(asdf==1) {
        	
        	String hi=scan.next();
        	if(hi.equals("e")) {
        		break;
        	}
        	int hi1=scan.nextInt();
        	
        	map.put(hi,hi1);
        	
        }
        
        
        Set<Entry<String, Integer>> set = map.entrySet();
        List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(set);
        Collections.sort( list, new Comparator<Entry<String, Integer>>()
        {
            public int compare( Entry<String, Integer> o1, Entry<String, Integer> o2 )
            {
                return (o2.getValue()).compareTo( o1.getValue() );
            }
        } );
        for(Entry<String, Integer> entry:list){
            System.out.println(entry.getKey()+", "+entry.getValue());
        }
    }
}