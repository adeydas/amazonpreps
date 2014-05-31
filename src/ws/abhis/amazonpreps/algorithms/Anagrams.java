package ws.abhis.amazonpreps.algorithms;

import java.util.Arrays;

public class Anagrams {
	
	public void findAnagrams(String word) {
		findAnagramsOfWord("", word);
	}
	
	//Find all anagrams of a string
	private void findAnagramsOfWord(String prefix, String word) {
		
		int length = word.length();
		if (length == 0) {
			return;
		} else {
			for (int i=0; i<length; i++) {
				System.out.println(word);
				findAnagramsOfWord(prefix + word.charAt(i), word.substring(0, i) + word.substring(i+1, word.length()));
			}
		}
	}
	
	//Compare two string if they are anagrams
	public boolean compareStringIfAnagrams(String word1, String word2) {
		word1 = sort(word1);
		word2 = sort(word2);
		
		if (word1.contains(word2)) {
			return true;
		} else {
			return false;
		}
	}
	
	private String sort(String word) {
		char[] c = word.toCharArray();
		Arrays.sort(c);
		String returnedString = "";
		for (int i=0; i<c.length; i++) {
			returnedString += c[i];
		}
		return returnedString; 
	}
	
	public static void main(String[] args) {
		Anagrams obj = new Anagrams();
		obj.findAnagrams("hello");
		System.out.println(obj.compareStringIfAnagrams("hello", "hell"));
		System.out.println(obj.compareStringIfAnagrams("hello", "abc"));
	}
}
