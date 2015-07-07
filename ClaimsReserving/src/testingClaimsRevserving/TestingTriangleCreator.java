package testingClaimsRevserving;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import claimsreversing.AccumulateData;
import claimsreversing.DataRowFormatter;
import claimsreversing.Product;
import claimsreversing.TriangleCreator;

public class TestingTriangleCreator {

	TriangleCreator creator;
	DataRowFormatter testFormatter;
	Map<String, Map<Integer, List<Product>>> testMap;
	
	@Before
	public void buildBefore() {
		testFormatter = DataRowFormatter.of(new AccumulateData("input").getUnstructuredProductData());
		creator = TriangleCreator.of(testFormatter.formatInputDataIntoStructuredProducts());
		testMap = creator.createTrianglesFromInputData();
	}
	
	@Test
	public void testGetNonCompKey() {
		assertTrue(testMap.containsKey("Non-Comp"));
	}
	@Test
	public void testGetCompKey() {
		assertTrue(testMap.containsKey("Comp"));
	}

	
	@Test
	public void testContainsYear() {
		assertEquals(testMap.get("Non-Comp").get(1990).get(0).getOriginYear(), Integer.valueOf(1990));
	}
}
