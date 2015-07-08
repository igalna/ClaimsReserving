package testingClaimsRevserving;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import claimsreversing.InputDataFromCSVFile;

public class TestingInputDataFromCSVFile {
	
	InputDataFromCSVFile store;
	String[] testData;
	
	@Before
	public void buildBefore() {
		store = new InputDataFromCSVFile("input");
		testData = store.getUnstructuredProductData().get(0);
	}
	
	@Test
	public void testFileExists() {
		assertNotNull(store);
	}
	
	
	@Test
	public void testDataExtractedInUnstructuredFormat() {
		String[] comparableData = {"Comp", "1992", "1992", "110.0"};
		assertArrayEquals(testData, comparableData);
	}
}