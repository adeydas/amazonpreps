/*
 * Given a string, find the length of the longest substring without repeating characters.
 *  For example, the longest substrings without repeating characters for “ABDEFGABEF” are “BDEFGA” and “DEFGAB”, with length 6. 
 *  For “BBBB” the longest substring is “B”, with length 1. 
 * For “GEEKSFORGEEKS”, there are two longest substrings shown in the below diagrams, with length 7.
 */
package ws.abhis.amazonpreps.geeksforgeeks;

import java.util.HashMap;

public class LengthLongestNonRepeatingSeq {
	private HashMap<Character, Integer> tempMap = new HashMap<Character, Integer>();
	private int globalMax = Integer.MIN_VALUE;
	
	public int solution(char[] sequence) {
		for (int i=0; i<sequence.length; i++) {
			if (!tempMap.containsKey(sequence[i]) || tempMap.isEmpty() ) {
				tempMap.put(sequence[i], 1);
				if (tempMap.size() > globalMax) {
					globalMax = tempMap.size();
				}
			} else {
				//tempMap.clear();
				tempMap.put(sequence[i], 1);
			}
		}
		if (tempMap.size() > globalMax) {
			globalMax = tempMap.size();
		}
		return globalMax;
	}
	
	public static void main(String[] args) {
		LengthLongestNonRepeatingSeq obj = new LengthLongestNonRepeatingSeq();
		String two = "ABCAD";
		String one = "GEEKSFORGEEKS";
		char[] arr = {'A','B','D','E','F','G','A','B','E','F'};
		int globalMax = obj.solution(one.toCharArray());
		System.out.println(globalMax);
	}
}
