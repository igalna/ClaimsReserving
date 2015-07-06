package testingClaimsRevserving;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import claimsreversing.AccumulateData;
import claimsreversing.Product;

public class TestingProduct {

	Product testProduct = Product.of("Comp", "1992", "1992", "110.0");
	AccumulateData store;
	String[] testData;
	
	@Before
	public void buildBefore() {
		store = new AccumulateData("input");
		testData = store.getUnstructuredProductData().get(0);
	}
	
	@Test
	public void testGetProduct() {
		assertEquals(testProduct.getProduct(), testData[0]);
	}
}
