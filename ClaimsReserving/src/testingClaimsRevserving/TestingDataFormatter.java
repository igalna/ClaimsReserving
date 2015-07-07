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
	Product firstProduct;
	Product lastProduct;
	
	@Before
	public void buildBefore() {
		testFormatter = DataRowFormatter.of(new AccumulateData("input").getUnstructuredProductData());
		formattedData = testFormatter.dataFormatter();
		firstProduct = formattedData.get(0);
		lastProduct = formattedData.get(formattedData.size()-1);
		
	}
	
	@Test
	public void testProductIsString() {
		assertEquals("Comp", firstProduct.getProduct());
	}
	
	@Test
	public void testOriginYearIsInteger() {
		assertEquals(Integer.valueOf(1992), firstProduct.getOriginYear());
	}
	
	@Test
	public void testDevelopmentYearIsInteger() {
		assertEquals(Integer.valueOf(1992), firstProduct.getDevelopmentYear());
	}
	
	@Test
	public void testIncrementValueIsDouble() {
		assertEquals(Double.valueOf(110.0), firstProduct.getIncrementValue());
	}
	


	@Test
	public void testFinalCaseProductIsString() {
		assertEquals("Non-Comp", lastProduct.getProduct());
	}
	
	@Test
	public void testFinalCaseOriginYear() {
		assertEquals(Integer.valueOf(1993), lastProduct.getOriginYear());
	}
}
