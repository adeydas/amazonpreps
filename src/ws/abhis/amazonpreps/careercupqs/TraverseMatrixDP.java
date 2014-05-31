/*
 * Find path from one cell to another in a matrix. Cannot traverse if it contains 1. Matrix contains
 * only 0 and 1.
 */

package ws.abhis.amazonpreps.careercupqs;

public class TraverseMatrixDP {
	public class Cell {
		private int row;
		private int column;
		public int getRow() {
			return row;
		}
		public void setRow(int row) {
			this.row = row;
		}
		public int getColumn() {
			return column;
		}
		public void setColumn(int column) {
			this.column = column;
		}
	}
	
	private int[][] originalMatrix;
	private int[][] auxMatrix;
	
	//create an auxillary matrix to store calculated values
	private void preProcess(int maxLength) {
		auxMatrix = new int[originalMatrix.length][maxLength];
		//Initialize all to -infinity
		for (int i=0; i<auxMatrix.length; i++) {
			for (int j=0; j<auxMatrix[i].length; j++) {
				auxMatrix[i][j] = Integer.MIN_VALUE;
			}
		}
	}
	
	public void inputVals (int[][] originalMatrix) {
		this.originalMatrix = originalMatrix;
	}
	
	public void solution(Cell startNode, Cell endNode) {
		
		int startPoint;
		int endPoint;
		if (startNode.row > endNode.row) {
			startPoint = endNode.row;
			endPoint = startNode.row;
		} else {
			startPoint = startNode.row;
			endPoint = endNode.row;
		}
		
		for (int i=startPoint; i<endPoint; i++) {
			
		}
	}
}
