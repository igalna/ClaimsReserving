package claimsreversing;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.opencsv.CSVReader;

public class Testing {

	public static void main(String[] args) {
		CSVReader reader;
		List<String[]> fileList;
		try {
			reader = new CSVReader(new FileReader("input.txt"), ',' ,'"', 1);
			
			fileList = reader.readAll();
			
			System.out.println(fileList.get(0));
			
			for (String[] strings : fileList) {
				for (String string : strings) {
					System.out.print(string + ",");
				}
				System.out.println();
			}
			
			

			InputDataFormatter testFormatter = InputDataFormatter.of(new InputDataFromCSVFile("input").getUnstructuredProductData());
			TriangleCreator creator = TriangleCreator.of(testFormatter.formatInputDataIntoStructuredProducts());
			
			System.out.println(creator.createTrianglesFromInputData().getClass());
			
			List<TriangleOfPaymentFigures> testList = creator.createTrianglesFromInputData();
	
			System.out.println(testList.size());
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
