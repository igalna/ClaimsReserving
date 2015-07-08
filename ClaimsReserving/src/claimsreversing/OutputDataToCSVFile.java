package claimsreversing;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.opencsv.CSVWriter;

public class OutputDataToCSVFile {
	
	private List<TriangleOfPaymentFigures> inputData;
	private CSVWriter writer;

	
	public OutputDataToCSVFile(String fileName, List<TriangleOfPaymentFigures> inputData) {
		this.inputData = inputData;
		this.writer = getCSVWriterFromFileName(fileName);
	}

	private CSVWriter getCSVWriterFromFileName(String fileName) {
		CSVWriter tempWriter = null;
		try {
			tempWriter = new CSVWriter(new FileWriter(fileName + ".txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return tempWriter;
	}
	
	public Integer getEarliestYear() {
		Integer result = Integer.MAX_VALUE;
		
		for (TriangleOfPaymentFigures triangle : inputData) {
			if (triangle.getOriginYear() < result) {
				result = triangle.getOriginYear();
			}
		}
		return result;
	}
	
	public Integer getNumberOfDevelopMentYears() {
		Integer earliestYear = getEarliestYear();
		Integer result = 1;
		
		for (TriangleOfPaymentFigures triangle : inputData) {
			for (Product product : triangle.getListOfProductsInTriangle()) {
				if (product.getDevelopmentYear() > earliestYear) {
					result = (product.getDevelopmentYear() - earliestYear) +1;
				}
			}
		}
		return result;
	}
}