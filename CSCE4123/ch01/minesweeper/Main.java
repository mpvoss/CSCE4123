package minesweeper;

import java.util.Scanner;

public class Main {

	public static void main(String[] arg) {

		Scanner scanner = new Scanner(System.in);
		int numRows = -1;
		int numCols = -1;
		int numField = 1;
		boolean shouldContinue = true;
		while (shouldContinue) {
			numRows = scanner.nextInt();
			numCols = scanner.nextInt();
			if ((numRows == 0) &&( numCols == 0)){
				shouldContinue = false;
//				System.out.println("False");
			}
			else{
//				System.out.println(numRows + " " + numCols);
			char[][] field;
			field = new char[numRows][numCols];
			int[][] result;
			result = new int[numRows][numCols];

			for (int row = 0; row < numRows; row++) {
				String str = scanner.next();
				for (int col = 0; col < numCols; col++) {
					field[row][col] = str.charAt(col);
				}
			}

			for (int row = 0; row < numRows; row++) {
				for (int col = 0; col < numCols; col++) {
					int numMines = -1;
					if (field[row][col] != '*')
						numMines = countAdjacentMines(field, row, col, numRows,
								numCols);
					result[row][col] = numMines;

				}
			}

				System.out.println();
			System.out.println("\nField #" + numField + ":");
			print(field, result, numRows, numCols);

			numField++;
		}}
		System.out.print("\n");
	}

	public static int countAdjacentMines(char[][] field, int row, int col,
			int numRows, int numCols) {
		int numAdjacentMines = 0;

		for (int rowModifier = -1; rowModifier < 2; rowModifier++) {
			for (int colModifier = -1; colModifier < 2; colModifier++) {
				if (!((rowModifier == 0) && (colModifier == 0))) {
					int newRow = row + rowModifier;
					int newCol = col + colModifier;

					if (isWithinArray(newCol, newRow, numRows, numCols)) {

						if (field[newRow][newCol] == '*')
							numAdjacentMines++;

					}
				}

			}
		}
		return numAdjacentMines;
	}

	public static boolean isWithinArray(int newCol, int newRow, int numRows,
			int numCols) {
		boolean result = false;

		if ((newCol >= 0) && (newRow >= 0) && (newRow < numRows)
				&& (newCol < numCols))
			result = true;
		return result;
	}

	public static void print(char[][] field, int[][] result, int n, int m) {
		for (int row = 0; row < n; row++) {
			if (row != 0)
			System.out.println();
			
			for (int col = 0; col < m; col++) {
				if (field[row][col] == '*')
					System.out.print('*');
				else
					System.out.print(result[row][col]);
			
			}
		}
	}
}