package ws.abhis.amazonpreps.algorithms.trees;

import java.util.Arrays;

public class ReverseAString {
	public static String reverseCStyleString(String s) {
        char[] str = s.toCharArray();
        //str.length/2 takes floor
        for(int i=0; i < ((str.length-1)/2); i++) {
            char temp = s.charAt(i);
            str[i] = str[str.length-1-i];
            str[str.length-1-i] = temp;
        }
        return new String(str);
    }
	
	public static String impl2(String s) {
		char[] l = s.toCharArray();
		int start = 0;
		int end = l.length - 1;
		while (start < end) {
			char temp = l[start];
			l[start] = l[end];
			l[end] = temp;
		}
		
		return Arrays.toString(l);
	}
	
	public static void main(String[] args) {
		
		ReverseAString obj = new ReverseAString();
		System.out.println(obj.reverseCStyleString("abc"));
		System.out.println(obj.impl2("abc"));
	}
}
