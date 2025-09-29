package organization;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class java {
	public static void main(String[] args) {
		HashMap<Integer , Integer> h = new HashMap<>();
		h.put(0, 12);h.put(1, 72);h.put(2, null);h.put(3, 67);
		h.put(4, 19);h.put(5, 14);h.put(6, 15);h.put(7, 18);
		
//		System.out.println(h.containsKey(3));
//		System.out.println(h.hashCode());
		System.out.println(h.values());
	    System.out.println(h.keySet());
	    System.out.println(h.putIfAbsent(8, 55));
	    System.out.println(h);
	    System.out.println(h.size());
		
 	}

}
