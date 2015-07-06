package testingClaimsRevserving;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import claimsreversing.AccumulateData;

public class TestingClaimsReserving {
	
	AccumulateData store;
	String[] testData;
	
	@Before
	public void buildBefore() {
		store = new AccumulateData("input");
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