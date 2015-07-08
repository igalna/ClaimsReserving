package testingClaimsRevserving;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import claimsreversing.InputDataFromCSVFile;
import claimsreversing.InputDataFormatter;
import claimsreversing.Product;

public class TestingDataFormatter {

	InputDataFormatter testFormatter;
	List<Product> formattedData;
	Product firstProduct;
	Product lastProduct;
	Product midProduct;
	
	@Before
	public void buildBefore() {
		testFormatter = InputDataFormatter.of(new InputDataFromCSVFile("input").getUnstructuredProductData());
		formattedData = testFormatter.formatInputDataIntoStructuredProducts();
		firstProduct = formattedData.get(0);
		lastProduct = formattedData.get(formattedData.size()-1);
		midProduct = formattedData.get(7);
		
	}
	
	@After
	public void tearDown() {
		testFormatter = null;
		formattedData = null;
		firstProduct = null;
		lastProduct = null;
		midProduct = null;
	}
	
	@Test
	public void testProductIsString() {
		assertEquals("Comp", firstProduct.getProductName());
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
		assertEquals("Non-Comp", lastProduct.getProductName());
	}
	
	@Test
	public void testFinalCaseOriginYear() {
		assertEquals(Integer.valueOf(1993), lastProduct.getOriginYear());
	}
	
	@Test
	public void testFinalCaseDevelopmentYear() {
		assertEquals(Integer.valueOf(1993), lastProduct.getDevelopmentYear());
	}
	
	@Test
	public void testFinalCaseIncrementValue() {
		assertEquals(Double.valueOf(100.0), lastProduct.getIncrementValue());
	}

	
	
	@Test
	public void testMidProductProductName() {
		assertEquals("Non-Comp", midProduct.getProductName());
	}
	
	@Test
	public void testMidProductOriginYear() {
		assertEquals(Integer.valueOf(1991), midProduct.getOriginYear());
	}
	
	@Test
	public void testMidProductDevelopmentYear() {
		assertEquals(Integer.valueOf(1992), midProduct.getDevelopmentYear());
	}
	
	@Test
	public void testMidProductIncrementValue() {
		assertEquals(Double.valueOf(75.0), midProduct.getIncrementValue());
	}
}