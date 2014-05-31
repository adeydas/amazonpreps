/*
 * 0-1 Knapsack problem using DP
 * Complexity: O(nW)
 */
package ws.abhis.amazonpreps.algorithms;

public class KnapSack01 {
	
	//Return the max value that can be put in a knapsack of capacity W
	public int solution(int W, int wt[], int[] val, int n) {
		int i, w;
		int[][] K = new int[n+1][W+1];
		
		//Build table K
		for (i=0; i<n; i++) {
			for (w=0; w<W; w++) {
				if (i==0 || w==0) {
					K[i][w]=0;
				} else if (wt[i-1] <= w) {
					K[i][w] = max(val[i-1] + K[i-1][w-wt[i-1]],  K[i-1][w]);
				} else {
					K[i][w] = K[i-1][w];
				}
			}
		}
		return K[n][W];
	}
	
	private int max(int a, int b) {
		if (a > b)
			return a;
		else
			return b;
	}
	
	public static void main(String[] args) {
		int val[] = {60, 100, 120};
	    int wt[] = {10, 20, 30};
	    int  W = 50;
	    int n = val.length;
	    
	    KnapSack01 obj = new KnapSack01();
	    System.out.println(obj.solution(W, wt, val, n));
	}
}
