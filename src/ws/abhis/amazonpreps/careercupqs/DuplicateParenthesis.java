/*
 * give an algorithm for finding duplicate parenthesis in a expression. 

example :


(( a + b ) + (( c + d )))
 */

package ws.abhis.amazonpreps.careercupqs;

import java.util.ArrayList;
import java.util.List;

public class DuplicateParenthesis {

	public class DPStack {
		private List<Character> stack;

		public DPStack() {
			stack = new ArrayList<Character>();
		}

		public char pop() {
			char value = stack.get(stack.size() - 1);
			stack.remove(stack.size() - 1);
			return value;
		}

		public void push(char value) {
			stack.add(value);
		}

		public char peek() {
			return stack.get(stack.size() - 1);
		}

		public boolean isStackEmpty() {
			return (stack.size() == 0);
		}
	}

	DPStack stack1 = new DPStack();
	
	public boolean checkDuplicates(String expr) {
		char[] exprArr = expr.toCharArray();
		return dupi(exprArr);
	}

	private boolean dupi(char[] c) {

		for (int i = 0; i < c.length; i++) {
			if (c[i] != ')') {
				// if not closing bracket or a token
				stack1.push(c[i]);
			} else {
				// if a closing bracket
				char k = stack1.pop();
				boolean tokenize = false;
				while (k != '(') {
					if (k != '(' || k != ')') {
						tokenize = true;
					}
					k = stack1.pop();
				}
				if (!tokenize) {
					return true;
				}
			}
		}

		return false;
	}

	public static void main(String[] args) {
		DuplicateParenthesis objDP = new DuplicateParenthesis();
		System.out.println(objDP.checkDuplicates("(a+b)"));
		System.out.println(objDP.checkDuplicates("((a+b))"));
		System.out.println(objDP.checkDuplicates("(((a+b))+c)"));
		System.out.println(objDP.checkDuplicates("((a+b)+c)"));
		System.out.println(objDP.checkDuplicates("()"));
	}

}
