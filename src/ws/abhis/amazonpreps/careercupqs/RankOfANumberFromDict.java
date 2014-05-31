/*
 * Provided a number dictionary and a number, x , which is formed from the number dictionary. 
Find the rank of the number x? Rank is defined as the position of the number x when all the number formed from the dictionary are sorted. 

Example 
Input :{4,1,5} 
X : 451 

Output : 4 

(145,154,415,451,514,541). 451 comes at 4th position
 */

package ws.abhis.amazonpreps.careercupqs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RankOfANumberFromDict {
	private List<Integer> allPermutations = new ArrayList<Integer>();
	
	//Generate all permutations
	public void generateAllPermutations(int[] values) {
		for (int i=0; i<values.length; i++) {
			//elements on the right side
			String addit = "";
			for (int j=i+1; j<values.length; j++) {
				addit += Integer.toString(values[j]);
			}
			
			String badit = "";
			//elements on the left side
			for (int k=0; k<i-1; i++) {
				badit += Integer.toString(values[k]);
			}
			String thisInt = Integer.toString(values[i]);
			allPermutations.add( Integer.parseInt(thisInt + badit + addit) );
			allPermutations.add( Integer.parseInt(thisInt + addit + badit) );
			
		}
	}
	
	//Sort all permuted values
	public void sortValues() {
		int[] arr = new int[allPermutations.size()];
		for (int i=0; i<arr.length; i++) {
			arr[i] = allPermutations.get(i);
		}
		Arrays.sort( arr );
		allPermutations.clear();
		for (int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
			allPermutations.add(arr[i]);
		}
	}
	
	
	public static void main(String[] args) {
		RankOfANumberFromDict obj = new RankOfANumberFromDict();
		int[] values = {4,1,5};
		obj.generateAllPermutations(values);
		obj.sortValues();
	}
	
}
