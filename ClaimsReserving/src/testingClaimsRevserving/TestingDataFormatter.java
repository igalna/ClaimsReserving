package testingClaimsRevserving;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import claimsreversing.DataRowFormatter;
import claimsreversing.AccumulateData;
import claimsreversing.Product;

public class TestingDataFormatter {

	DataRowFormatter testFormatter;
	List<Product> formattedData;
	Product testProduct;
	
	@Before
	public void buildBefore() {
		testFormatter = DataRowFormatter.of(new AccumulateData("input").getUnstructuredProductData());
		formattedData = testFormatter.dataFormatter();
		testProduct = formattedData.get(0);
		
	}
	
	@Test
	public void testProductIsString() {
		assertEquals("Comp", testProduct.getProduct());
	}
	
	@Test
	public void testOriginYearIsInteger() {
		assertEquals(Integer.valueOf(1992), testProduct.getOriginYear());
	}
	
	@Test
	public void testDevelopmentYearIsInteger() {
		assertEquals(Integer.valueOf(1992), testProduct.getDevelopmentYear());
	}
	
	@Test
	public void testIncrementValueIsDouble() {
		assertEquals(Double.valueOf(110.0), testProduct.getIncrementValue());
	}

}
