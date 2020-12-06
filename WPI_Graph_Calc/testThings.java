public class testThings {
    public static void main(String[] args) {
        String str= "(3x^2+2)+5";
        String temp = "";
		for(int i=str.length()-1; i>=0; i++){
			temp += str.charAt(i);
        }
        str=temp;
        System.out.println(str);
    }
}
