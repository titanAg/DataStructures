//Kyle Orcutt

public class Maze {
	private int N, startX, startY, endX, endY;
	private char[][] map;
	
	/**
	 * Creates a maze object of size N, beginning (sX, SY), target (eX, eY) and
	 * the characters of the maze are stored in a char table

	 * @param N
	 * @param sX
	 * @param sY
	 * @param eX
	 * @param eY
	 * @param m
	 */
	public Maze (int N, int sX, int sY, int eX, int eY, char[][] m) {
		this.N = N;
		startX = sX; startY = sY; endX = eX; endY = eY;
		map = m;
	}
	
	/**
	 * Returns N for an N-by-N maze
	 * @return
	 */
	public int getSize() {
		return N;
	}
	
	/**
	 * gets the character at position (row,col)
	 * @param row
	 * @param col
	 * @return
	 */
	public char get(int row, int col) {
		if (row >= N) {
			System.err.println("Your row " + row + " is out of bounds for size " + N);
			return '#';
		}
		else if (col >= N) {
			System.err.println("Your col " + col + " is out of bounds for size " + N);		
			return '#';
		}
		else return map[row][col];
	}

	/**
	 * returns the row index of the target location
	 * @return
	 */
	public int getTargetRow() {
		return endX;
	}

	/** returns the col index of the target location
	 * 
	 * @return
	 */
	public int getTargetCol() {
		return endY;
	}

	/**
	 * returns the row index of the start location
	 * @return
	 */
	public int getStartRow() {
		return startX;
	}

	/** returns the col index of the start location
	 * 
	 * @return
	 */
	public int getStartCol() {
		return startY;
	}

}
