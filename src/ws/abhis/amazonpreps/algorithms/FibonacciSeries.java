/*
 * Calculate fibonacci series to a point.
 */

package ws.abhis.amazonpreps.algorithms;

public class FibonacciSeries {
	
	//Exponential time complexity
	public int recursiveSolution(int n) {
		System.out.println(n);
		if (n <= 1) {
			return n;
		}
		return (recursiveSolution(n-1) + recursiveSolution(n-2));
	}
	
	public void iterativeSolution(int n) {
		int febCount = n;
        int[] feb = new int[febCount];
        feb[0] = 0;
        feb[1] = 1;
        for(int i=2; i < febCount; i++){
            feb[i] = feb[i-1] + feb[i-2];
        }

        for(int i=0; i< febCount; i++){
                System.out.print(feb[i] + " ");
        }
	}
	
	//Store the calculated parts in an array
	//Complexity: O(n)
	public int dynamicSolution(int n) {
		//Array to store the fibonacci numbers
		int[] f = new int[n+1];
		f[0] = 0;
		f[1] = 1;
		
		for (int i=2; i<=n; i++) {
			f[i] = f[i-1] + f[i-2];
		}
		
		return f[n];
	}
	
	
	
	public static void main(String[] args) {
		FibonacciSeries obj = new FibonacciSeries();
		System.out.println(obj.dynamicSolution(9));
	}
}
