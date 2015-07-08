package testingClaimsRevserving;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import claimsreversing.InputDataFromCSVFile;
import claimsreversing.DataRowFormatter;
import claimsreversing.Triangle;
import claimsreversing.TriangleCreator;

public class TestingTriangleCreator {

	TriangleCreator creator;
	DataRowFormatter testFormatter;
	List<Triangle> testList;
	
	@Before
	public void buildBefore() {
		testFormatter = DataRowFormatter.of(new InputDataFromCSVFile("input").getUnstructuredProductData());
		creator = TriangleCreator.of(testFormatter.formatInputDataIntoStructuredProducts());
		testList = creator.createTrianglesFromInputData();
	}

	@Test
	public void testAddTriangle() {
		assertEquals(testList.get(0).getProduct(), "Comp");
	}
	
	@Test
	public void testGetSecondTriangle() {
		assertEquals(testList.get(1).getProduct(), "Comp");
		assertEquals(testList.get(1).getOriginYear(), Integer.valueOf(1993));
	}
}