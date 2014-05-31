/*
 * write a program to generate random numbers without using the in-built functions
 */

package ws.abhis.amazonpreps.careercupqs;

public class GenerateRandomNumbers {
	public long genRandomNumbers(int lowerBound, int upperBound) {
		return (System.currentTimeMillis() % upperBound)/lowerBound;
	}
	
	public static void main(String[] args) {
		GenerateRandomNumbers obj = new GenerateRandomNumbers();
		System.out.println(obj.genRandomNumbers(2, 100));
	}
}
