package salesReport_v1;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TwoDimRaggedArrayUtilitySTUDENT_Test {
	//STUDENT fill in dataSetSTUDENT with values, it must be a ragged array
	private double[][] dataSet1 = {{7,5},{9,5,3},{8,2,4,2}};
	private double[][] dataSet2 = {{5,8,4},{2,8},{2,9,5,2},{9,1,8}};
	private double[][] dataSet3 = {{8.8,5.2,4.8,7.2},{8.8,6.6},{3.1,5.3,6.2},{11.6,6.9,7.3,2.7}};
	private double[][] dataSet4 = {{-9.5,-3.3,5.25},{-3.4,5.2},{3.3,-1.5},{-7.8,3.3,-8.9,3.6}};
	
	
	private double[][] dataSetSTUDENT = null;
	
	private File inputFile,outputFile;

	@Before
	public void setUp() throws Exception {
		outputFile = new File("TestOut.txt");
	}

	@After
	public void tearDown() throws Exception {
		dataSetSTUDENT = null;
		inputFile = outputFile = null;
	}

	/**
	 * Student Test getTotal method
	 * Return the total of all the elements in the two dimensional array
	 */
	@Test
	public void testGetTotal() {
		//fail("Student testGetTotal not implemented");	
		assertEquals(45.0,TwoDimRaggedArrayUtility.getTotal(dataSet1),.001);
		assertEquals(63.0,TwoDimRaggedArrayUtility.getTotal(dataSet2),.001);
		assertEquals(84.5,TwoDimRaggedArrayUtility.getTotal(dataSet3),.001);
		assertEquals(-13.75,TwoDimRaggedArrayUtility.getTotal(dataSet4),.001);
	}

	/**
	 * Student Test getAverage method
	 * Return the average of all the elements in the two dimensional array
	 */
	@Test
	public void testGetAverage() {
		assertEquals(5.0,TwoDimRaggedArrayUtility.getAverage(dataSet1),.001);
		assertEquals(5.25,TwoDimRaggedArrayUtility.getAverage(dataSet2),.001);
		assertEquals(6.5,TwoDimRaggedArrayUtility.getAverage(dataSet3),.001);
		assertEquals(-1.25,TwoDimRaggedArrayUtility.getAverage(dataSet4),.001);
	}

	/**
	 * Student Test getRowTotal method
	 * Return the total of all the elements of the row.
	 * Row 0 refers to the first row in the two dimensional array
	 */
	@Test
	public void testGetRowTotal() {
		assertEquals(17.0,TwoDimRaggedArrayUtility.getRowTotal(dataSet1,1),.001);
		assertEquals(10.0,TwoDimRaggedArrayUtility.getRowTotal(dataSet2,1),.001);
		assertEquals(17.0,TwoDimRaggedArrayUtility.getRowTotal(dataSet2,0),.001);
		assertEquals(28.5,TwoDimRaggedArrayUtility.getRowTotal(dataSet3,3),.001);
		assertEquals(15.4,TwoDimRaggedArrayUtility.getRowTotal(dataSet3,1),.001);
		assertEquals(1.8,TwoDimRaggedArrayUtility.getRowTotal(dataSet4,1),.001);
		assertEquals(-9.8,TwoDimRaggedArrayUtility.getRowTotal(dataSet4,3),.001);
	}


	/**
	 * Student Test getColumnTotal method
	 * Return the total of all the elements in the column. If a row in the two dimensional array
	 * doesn't have this column index, it is not an error, it doesn't participate in this method.
	 * Column 0 refers to the first column in the two dimensional array
	 */
	@Test
	public void testGetColumnTotal() {
		assertEquals(24.0,TwoDimRaggedArrayUtility.getColumnTotal(dataSet1,0),.001);
		assertEquals(17.0,TwoDimRaggedArrayUtility.getColumnTotal(dataSet2,2),.001);
		assertEquals(24.0,TwoDimRaggedArrayUtility.getColumnTotal(dataSet3,1),.001);
		assertEquals(-17.4,TwoDimRaggedArrayUtility.getColumnTotal(dataSet4,0),.001);
		assertEquals(3.7,TwoDimRaggedArrayUtility.getColumnTotal(dataSet4,1),.001);
	}


	/**
	 * Student Test getHighestInArray method
	 * Return the largest of all the elements in the two dimensional array.
	 */
	@Test
	public void testGetHighestInArray() {
		assertEquals(9.0,TwoDimRaggedArrayUtility.getHighestInArray(dataSet1),.001);
		assertEquals(9.0,TwoDimRaggedArrayUtility.getHighestInArray(dataSet2),.001);
		assertEquals(11.6,TwoDimRaggedArrayUtility.getHighestInArray(dataSet3),.001);
		assertEquals(5.25,TwoDimRaggedArrayUtility.getHighestInArray(dataSet4),.001);
	}
	

	/**
	 * Test the writeToFile method
	 * write the array to the outputFile File
	 * then read it back to make sure formatted correctly to read
	 * @throws FileNotFoundException 
	 * 
	 */
	@Test
	public void testWriteToFile() throws FileNotFoundException {
		double[][] array=null;
		try {
			TwoDimRaggedArrayUtility.writeToFile(dataSet2, outputFile);
		} catch (Exception e) {
			fail("This should not have caused an Exception");
		}
		array = TwoDimRaggedArrayUtility.readFile(outputFile);
		assertEquals(5.0, array[0][0],.001);
		assertEquals(8.0, array[0][1],.001);
		assertEquals(4.0, array[0][2],.001);
		assertEquals(2.0, array[1][0],.001);
		assertEquals(8.0, array[1][1],.001);
		assertEquals(2.0, array[2][0],.001);
		assertEquals(9.0, array[2][1],.001);
		assertEquals(5.0, array[2][2],.001);
		assertEquals(9.0, array[3][0],.001);
		assertEquals(1.0, array[3][1],.001);
		assertEquals(8.0, array[3][2],.001);
	}

}
