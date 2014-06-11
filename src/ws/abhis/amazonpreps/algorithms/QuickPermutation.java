package ws.abhis.amazonpreps.algorithms;

public class QuickPermutation {
	public static void combString(String s) {
	    // Print initial string, as only the alterations will be printed later
	    System.out.println(s);   
	    char[] a = s.toCharArray();
	    int n = a.length;
	    int[] p = new int[n];  // Index control array initially all zeros
	    int i = 1;
	    while (i < n) {
	        if (p[i] < i) {
	            int j = ((i % 2) == 0) ? 0 : p[i];
	            swap(a, i, j);
	            // Print current
	            System.out.println(join(a));
	            p[i]++;
	            i = 1;
	        }
	        else {
	            p[i] = 0;
	            i++;
	        }
	    }
	}

	private static String join(char[] a) {
	    StringBuilder builder = new StringBuilder();
	    builder.append(a);
	    return builder.toString();
	}

	private static void swap(char[] a, int i, int j) {
	    char temp = a[i];
	    a[i] = a[j];
	    a[j] = temp;
	}
	
	public static void main(String[] args) {
		combString("lamp");
	}
}
