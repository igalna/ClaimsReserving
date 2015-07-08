package testingClaimsRevserving;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import claimsreversing.InputDataFromCSVFile;
import claimsreversing.DataRowFormatter;
import claimsreversing.TriangleOfPaymentFigures;
import claimsreversing.TriangleCreator;

public class TestingTriangleCreator {

	DataRowFormatter testFormatter = DataRowFormatter.of(new InputDataFromCSVFile("input").getUnstructuredProductData());
	TriangleCreator creator = TriangleCreator.of(testFormatter.formatInputDataIntoStructuredProducts());
	List<TriangleOfPaymentFigures> testList = creator.createTrianglesFromInputData();
	

	@Test
	public void testAddTriangle() {
		assertEquals(testList.get(0).getProduct(), "Comp");
	}
	
	
	@Test
	public void testGetSecondTriangle() {
		assertEquals(testList.get(1).getProduct(), "Comp");
		assertEquals(testList.get(1).getOriginYear(), Integer.valueOf(1993));
	}
	@Test
	public void testSecondTriangleOnlyHasItselfAsProduct() {
		assertEquals(1, testList.get(1).getListOfProductsInTriangle().size());
		assertEquals("Comp", testList.get(1).getListOfProductsInTriangle().get(0).getProduct());
		assertEquals(Integer.valueOf(1993), testList.get(1).getListOfProductsInTriangle().get(0).getOriginYear());
	}
	
	
	@Test
	public void testThirdTriangleIsFirstNonCompTriangle() {
		assertEquals("Non-Comp", testList.get(2).getProduct());
		assertEquals(Integer.valueOf(1990), testList.get(2).getOriginYear());
	}
	
	@Test
	public void testThirdTriangleContainsAllThreeDevelopmentYears() {
		assertEquals(3, testList.get(2).getListOfProductsInTriangle().size());
		
		assertEquals(Integer.valueOf(1990), testList.get(2).getListOfProductsInTriangle().get(0).getDevelopmentYear());
		assertEquals(Integer.valueOf(1991), testList.get(2).getListOfProductsInTriangle().get(1).getDevelopmentYear());
		assertEquals(Integer.valueOf(1993), testList.get(2).getListOfProductsInTriangle().get(2).getDevelopmentYear());
		System.out.println(testList.get(2).getListOfProductsInTriangle());
	}
	
	
	
	@Test
	public void testLastTriangle() {
		System.out.println(testList.size());
		
		assertEquals("Non-Comp", testList.get(testList.size() -1).getProduct());
		assertEquals(Integer.valueOf(1993), testList.get(testList.size() -1).getOriginYear());
	}
	
	@Test
	public void testLastTriangleContains() {
		assertEquals(1, testList.get(testList.size() -1).getListOfProductsInTriangle().size());
		
		assertEquals(Integer.valueOf(1993), testList.get(testList.size() -1).getListOfProductsInTriangle().get(0).getDevelopmentYear());
		assertEquals(Double.valueOf(100.0), testList.get(testList.size() -1).getListOfProductsInTriangle().get(0).getIncrementValue());
	}
	
}