package ws.abhis.amazonpreps.algorithms.trees;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class InsertPercentTwentyInPlaceOfSpace {
	public String solution(String s) {
		List<Character> ls = new ArrayList<Character>();

		char[] c = s.toCharArray();
		for (int i=0; i<c.length; i++) {
			ls.add(c[i]);
		}
		StringBuilder s1 = new StringBuilder();
		for (int i=0; i<ls.size(); i++) {
			char v = ls.get(i);
			if (v == ' ') {
				s1.append("%20");
			} else {
				s1.append(v);
			}
		}
		return s1.toString();
	}
	
	public void removeDuplicates(char[] arr) {
	    Map<Character, Integer> mp = new LinkedHashMap<Character, Integer>();
	    for (int i=0; i<arr.length; i++) {
	        char v = arr[i];
	        if (mp.containsKey(v)) {
	            int f = mp.get(v);
	            mp.put(v, ++f);
	        } else {
	            mp.put(v, 1);
	        }
	    }
	    for (Entry e : mp.entrySet()) {
	         System.out.println(e.getKey());
	    }
	}

	
	public static void main(String[] args) {
		InsertPercentTwentyInPlaceOfSpace obj = new InsertPercentTwentyInPlaceOfSpace();
		System.out.println(obj.solution("hello there. how are you?"));
		
		char[] dup = {'h','e','l','l','o'};
		obj.removeDuplicates(dup);
	}
	
	
}
