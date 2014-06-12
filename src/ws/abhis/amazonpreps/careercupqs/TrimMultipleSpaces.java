/*
 * Given a string with multiple spaces write a function to in-place trim all spaces leaving a single space between words 
e.g. 
_ _ _ Hello _ _ _ World _ _ _ 
Hello _ World _ _ _ _ _ _ _ _ _
 */

package ws.abhis.amazonpreps.careercupqs;

public class TrimMultipleSpaces {
	public String trim(String word) {
		char[] p = word.toCharArray();
		tr(p);
		return new String(p);
	}

	private void tr(char[] word) {
		boolean flag = false;
		for (int i = 0; i < word.length; i++) {
			if (word[i] == ' ' && flag) {
				bringInFront(word, i);
			} else if (word[i] == ' ' && !flag) {
				bringInFront(word, i);
				flag = true;
			} else {
				flag = false;
			}
		}
	}

	private void bringInFront(char[] word, int l) {
		for (int i = l; i < word.length; i++) {
			if (i + 1 < word.length - 1) {
				word[i] = word[i + 1];
			}
		}
	}

	public static void main(String[] args) {
		TrimMultipleSpaces obj = new TrimMultipleSpaces();
		System.out.println(obj.trim("   Hello   World   "));
	}
}
