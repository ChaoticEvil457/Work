package JavaGraph;

import java.util.ArrayList;

class Sort{
    public static void main(String[] args){
        ArrayList<Integer> ray = new ArrayList<Integer>();
        for(int i=0;i<10;i++){
            ray.add((int)(Math.random()*200));
        }
        for (int i =0;i<ray.size()-1;i++) {
            if(ray.get(i)>ray.get(i+1)){
                ray.remove(ray.get(i+1));
                i--;
            }
        }
        for (int i : ray) {
            System.out.println(i);
        }
    }
}