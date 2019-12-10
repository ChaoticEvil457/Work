package Summertech;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap h=new HashMap();
		
		System.out.println(h.get("hello"));
		
		h.add("hello","bye");
		h.add(" ", "1");
		h.add("  ", "2");
		h.add("   ", "3");
		h.add("    ", "4");
		h.add("     ", "5");
		h.add("      ", "6");
		h.add("       ", "7");
		h.add("        ", "8");
		h.add("         ", "9");
		h.add("          ", "10");
		h.add("           ", "11");
		h.add("            ", "12");
		h.add("             ", "13");
		System.out.println(h.get("hello"));
		System.out.println(h.get(" "));
		System.out.println(h.get("  "));
		System.out.println(h.get("   "));
		System.out.println(h.get("    "));
		System.out.println(h.get("     "));
		System.out.println(h.get("      "));
		System.out.println(h.get("       "));
		System.out.println(h.get("        "));
		System.out.println(h.get("         "));
		System.out.println(h.get("          "));
		System.out.println(h.get("           "));
		System.out.println(h.get("            "));
		System.out.println(h.get("             "));
	}
}
