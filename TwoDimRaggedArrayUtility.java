package salesReport_v1;

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;

public class TwoDimRaggedArrayUtility {

	public static double[][] readFile(File inputFile) throws FileNotFoundException {
		Scanner keyboard1 = new Scanner(inputFile);
		Scanner keyboard2 = new Scanner(inputFile);
		double[][] salesInputArray = null;
		int rows = 0, currentRow = 0;

		// Count rows in array
		while (keyboard1.hasNextLine()) {
			rows++;
			keyboard1.nextLine();
		}
		keyboard1.close();

		// Intializie rows
		salesInputArray = new double[rows][];

		// Read row data
		while (keyboard2.hasNextLine()) {
			String line = keyboard2.nextLine();
			String columns[] = line.trim().split(" ");
			salesInputArray[currentRow] = new double[columns.length];

			for (int col = 0; col < columns.length; col++) {
				salesInputArray[currentRow][col] = Double.parseDouble(columns[col]);
			}
			currentRow++;
		}
		keyboard2.close();

		return salesInputArray;
	}

	public static void writeToFile(double[][] inputFile, File salesFile) throws IOException {
		// input double[][] & file
		FileWriter outputFile = new FileWriter(salesFile);

		for (int row = 0; row < inputFile.length; row++) {
			for (int col = 0; col < inputFile[row].length; col++) {
				outputFile.write(inputFile[row][col] + " ");

			}
			outputFile.write("\n");
		}
		outputFile.close();
	}

	/*
	 * @param Method takes in a two-dimensional array of doubles and returns the sum
	 * of all elements inside the array
	 */
	public static double getTotal(double inputFile[][]) {
		double sum = 0.0;

		for (int row = 0; row < inputFile.length; row++) {

			for (int col = 0; col < inputFile[row].length; col++) {
				sum += inputFile[row][col];
			}
		}
		return sum;

	}

	/*
	 * @param Method takes in a two-dimensional array of doubles and returns the
	 * average of all elements inside the array
	 */
	public static double getAverage(double inputFile[][]) {
		double sum = 0.0;
		double average = 0;
		int numOfElements = 0;
		for (int row = 0; row < inputFile.length; row++) {
			for (int col = 0; col < inputFile[row].length; col++) {
				sum += inputFile[row][col];
				numOfElements++;
			}
		}

		average = sum / numOfElements;
		return average;

	}

	/*
	 * @param Method takes in a two-dimensional array of doubles and returns the he
	 * sum will be all of the elements in the target row added together.
	 */
	public static double getRowTotal(double inputFile[][], int row) {
		double rowTotal = 0.0;
		for (int col = 0; col < inputFile[row].length; col++) {
			rowTotal += inputFile[row][col];
		}
		return rowTotal;
	}

	/*
	 * @param Method takes in a two-dimensional array of doubles and returns the he
	 * sum will be all of the elements in the target column added together.
	 */
	public static double getColumnTotal(double inputFile[][], int col) {
		double colTotal = 0.0;

		for (int row = 0; row < inputFile.length; row++) {
			//Check if the length of the row is large enough to incorporate target column
			if (col >= inputFile[row].length) continue;
			
			colTotal += inputFile[row][col];
		}
	return colTotal;

}

	/*
	 * @param Method takes in a two-dimensional array of doubles and returns the
	 * largest element in a row.
	 */
	public static double getHighestInRow(double inputFile[][], int rowInput) {
		double highestInRow = 0.0;

		for (int col = 0; col < inputFile[rowInput].length; col++) {
			if (inputFile[rowInput][col] > highestInRow) {
				highestInRow = inputFile[rowInput][col];
			}
		}
		return highestInRow;
	}

	/*
	 * @param Method takes in a two-dimensional array of doubles and returns the
	 * index of the largest element in a row.
	 */
	public static int getHighestInRowIndex(double[][] inputFile, int rowIndex) {
		double maxVal = 0.0;
		int hirIndex = 0;
		for (int col = 0; col < inputFile[rowIndex].length; col++) {
			if (inputFile[rowIndex][col] > maxVal) {
				maxVal = inputFile[rowIndex][col];
				hirIndex = col;
			}
		}
		return hirIndex;
	}

	/*
	 * @param Method takes in a two-dimensional array of doubles and returns the
	 * smallest element in a row.
	 */
	public static double getLowestInRow(double inputFile[][], int row) {
		double lowestInRow = inputFile[row][0];

		for (int col = 0; col < inputFile[row].length; col++) {
			if (lowestInRow > inputFile[row][col]) {
				lowestInRow = inputFile[row][col];
			}
		}
		return lowestInRow;
	}

	public static int getLowestInRowIndex(double inputFile[][], int row) {
		double lirValue = inputFile[row][0];
		int lirIndex = 0;
		for (int col = 0; col < inputFile[row].length; col++) {
			if (inputFile[row][col] < lirValue) {
				lirValue = inputFile[row][col];
				lirIndex = col;
			}
		}
		return lirIndex;
	}

	public static double getHighestInColumn(double inputFile[][], int col) {
		double hicVal = inputFile[0][col];
		for (int row = 0; row < inputFile.length; row++) {
			//Check if the length of the row is large enough to incorporate target column
			if (col >= inputFile[row].length) continue;
			
			if (inputFile[row][col] > hicVal) {
				hicVal = inputFile[row][col];
			}
		}
		return hicVal;
	}

	public static int getHighestInColumnIndex(double inputFile[][], int col) {
		double hicVal = Double.NEGATIVE_INFINITY;
		int hicIndex = 0;

		for (int row = 0; row < inputFile.length; row++) {
			//Check if the length of the row is large enough to incorporate target column
			if (col >= inputFile[row].length) continue;
			
			if (inputFile[row][col] > hicVal) {
				hicVal = inputFile[row][col];
				hicIndex = row;
			}
		}
		return hicIndex;
	}

	public static double getLowestInColumn(double inputFile[][], int col) {
		double licVal = inputFile[0][col];

		for (int row = 0; row < inputFile.length; row++) {
			//Check if the length of the row is large enough to incorporate target column
			if (col >= inputFile[row].length) continue;
			
			if (inputFile[row][col] < licVal) {
				licVal = inputFile[row][col];
			}
		}
		return licVal;
	}

	public static int getLowestInColumnIndex(double inputFile[][], int col) {
		double licVal = inputFile[0][col];
		int licIndex = 0;

		for (int row = 0; row < inputFile.length; row++) {
			//Check if the length of the row is large enough to incorporate target column
			if (col >= inputFile[row].length) continue;
			
			if (inputFile[row][col] < licVal) {
				licVal = inputFile[row][col];
				
				licIndex = row;
			}
		}
		return licIndex;
	}

	public static double getHighestInArray(double inputArray[][]) {
		double highestInArray = inputArray[0][0];

		for (int row = 0; row < inputArray.length; row++) {

			for (int col = 0; col < inputArray[row].length; col++) {

				if (inputArray[row][col] > highestInArray)
					highestInArray = inputArray[row][col];
			}
		}
		return highestInArray;
	}

	public static double getLowestInArray(double inputArray[][]) {
		double lowestInArray = inputArray[0][0];

		for (int row = 0; row < inputArray.length; row++) {

			for (int col = 0; col < inputArray[row].length; col++) {
				if (inputArray[row][col] < lowestInArray)
					lowestInArray = inputArray[row][col];
			}
		}
		return lowestInArray;

	}

}
