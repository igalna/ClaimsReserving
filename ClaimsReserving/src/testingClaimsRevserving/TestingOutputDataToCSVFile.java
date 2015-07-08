package testingClaimsRevserving;

import java.util.List;

import org.junit.Test;

import claimsreversing.InputDataFormatter;
import claimsreversing.InputDataFromCSVFile;
import claimsreversing.OutputDataToCSVFile;
import claimsreversing.TriangleCreator;
import claimsreversing.TriangleOfPaymentFigures;

public class TestingOutputDataToCSVFile {

	InputDataFormatter testFormatter = InputDataFormatter.of(new InputDataFromCSVFile("input").getUnstructuredProductData());
	TriangleCreator creator = TriangleCreator.of(testFormatter.formatInputDataIntoStructuredProducts());
	List<TriangleOfPaymentFigures> testList = creator.createTrianglesFromInputData();
	OutputDataToCSVFile output = new OutputDataToCSVFile("output", testList);
	
	@Test
	public void test() {
		//assertEquals()
	}

}
