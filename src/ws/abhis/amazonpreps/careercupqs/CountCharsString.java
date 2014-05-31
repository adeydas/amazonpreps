/*
 * count the consecutive chars in a string. 

Example input string: BBSBSS 
output string: B2S1B1S2 

* ignore case . out put is always uppercase 
input : AaV 
output: A2V1
 */

package ws.abhis.amazonpreps.careercupqs;

public class CountCharsString {
	public void solution(String elements) {
		//convert all to upper case
		char[] e = elements.toUpperCase().toCharArray();
		char lastElement = 0;
		int counter = 0;
		String outputString = "";
		for (int i=0; i<e.length; i++) {
			//Base case
			if (lastElement == 0) {
				lastElement = e[i];
			}
			
			if (lastElement == e[i]) {
				counter++;
			} else {
				outputString += Character.toString(lastElement) + counter;
				counter = 1;
				lastElement = e[i];
			}
		}
		//for the last set
		outputString += Character.toString(lastElement) + counter;
		System.out.println(outputString);
	}
	
	public static void main(String[] args) {
		CountCharsString obj = new CountCharsString();
		obj.solution("BBSBSS");
	}
}
