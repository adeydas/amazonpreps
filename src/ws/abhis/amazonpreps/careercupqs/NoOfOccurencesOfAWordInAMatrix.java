/*
 * given a N x N matrix find the no. of times a word is present in that matrix. constraints you can move in 3 directions from one cell 1. forward , 2. down 3. diagonal . Find all teh occurance of all the word 

forward means right (x+1,y) 
down mean (x,y+1) 
diagonal means (x+1,y+1) 

it can be done with BFS. {search the no. of occurance of a given word example "sachin" in the whole NxN matrix} 

w | s | r | t | g | g| 
a | a | c | h | i | n | 
k | c | h | u | j | j | 
o | h | i | n | y | q | 

in this sachin can be found out 3 times.
 */

package ws.abhis.amazonpreps.careercupqs;

public class NoOfOccurencesOfAWordInAMatrix {
	private char[][] arr = new char[4][6];
	
	private void inputData() {
		arr[0][0] = 'w';
		arr[0][1] = 's';
		arr[0][2] = 'r';
		arr[0][3] = 't';
		arr[0][4] = 'g';
		arr[0][5] = 'g';
		arr[1][0] = 'a';
		arr[1][1] = 'a';
		arr[1][2] = 'c';
		arr[1][3] = 'h';
		arr[1][4] = 'i';
		arr[1][5] = 'n';
		arr[2][0] = 'k';
		arr[2][1] = 'c';
		arr[2][2] = 'h';
		arr[2][3] = 'u';
		arr[2][4] = 'j';
		arr[2][5] = 'j';
		arr[3][0] = 'o';
		arr[3][1] = 'h';
		arr[3][2] = 'i';
		arr[3][3] = 'n';
		arr[3][4] = 'y';
		arr[3][5] = 'q';
	}
	
	
}
