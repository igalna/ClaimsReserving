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
	
/*	private int getEarliestYear() {
		return inputData.stream().min(TriangleOfPaymentFigures::getOriginYear);	
	}
	
	private int getNumberOfDevelopMentYears() {
		return (getEarliestYear() - inputData.stream().max(TriangleOfPaymentFigures::getOriginYear)) + 1;
	}
*/
}