/*
 * m[0] = 0 //summation of empty sets
 * http://upload.wikimedia.org/math/6/3/9/639a8c4e9056cd0402e3fef9cbac56d6.png
 */

package ws.abhis.amazonpreps.algorithms;

public class UnboundedKnapsack {
	public int solution(int[] v, int[] w, int C) {
		int[] sol, mySol;
		int i, myFinalSol;

		sol = new int[v.length];
		mySol = new int[v.length];

		/*
		 * --------------------------- Base cases ---------------------------
		 */
		if (C == 0) {
			return (0);
		}

		/*
		 * ============================================== Divide and conquer
		 * procedure ==============================================
		 */
		/*
		 * --------------------------------------- Solve the appropriate smaller
		 * problems ---------------------------------------
		 */
		for (i = 0; i < v.length; i++) {
			if (C >= w[i])
				sol[i] = solution(v, w, C - w[i]); // Knapsack capacity reduced by w[i]
											// because it has item i packed in
											// it already
			else
				sol[i] = 0; // Not enough space to pack item i
		}

		/*
		 * --------------------------------------------- Use the solutions to
		 * the smaller problems to solve original problem
		 * ---------------------------------------------
		 */
		for (i = 0; i < v.length; i++) {
			if (C >= w[i])
				mySol[i] = sol[i] + v[i]; // Value is increased by v[i]
											// because it has item i packed in
											// it already
			else
				mySol[i] = 0; // Not enough space to pack item i
		}

		/* *************************
		 * Find the best (maximum)************************
		 */
		myFinalSol = mySol[0];
		for (i = 1; i < v.length; i++)
			if (mySol[i] > myFinalSol)
				myFinalSol = mySol[i];

		return myFinalSol; // Return the overal best solution
	}
}
