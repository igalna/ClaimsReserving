package testingClaimsRevserving;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import claimsreversing.AccumulateData;
import claimsreversing.Product;

public class TestingProduct {

	Product testProduct = Product.of("Comp", 1992, 1992, 110.0);
	AccumulateData storeOfUnstructuredData;
	String[] testData;
	
	@Before
	public void buildBefore() {
		storeOfUnstructuredData = new AccumulateData("input");
		testData = storeOfUnstructuredData.getUnstructuredProductData().get(0);
	}
	
	@Test
	public void testGetProduct() {
		assertEquals(testProduct.getProduct(), testData[0]);
	}

	@Test
	public void testGetOrigin() {
		assertEquals(1992, Integer.parseInt(testData[1]));
	}
	
	@Test
	public void testGetDevelopmentYear() {
		assertEquals(1992, Integer.parseInt(testData[2]));
	}
	
	@Test
	public void testGetIncrementValue() {
		assertEquals(110.0, Double.parseDouble(testData[3]), 0.0);
	}
}
