package claimsreversing;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import lombok.Getter;

import com.opencsv.CSVReader;


public class AccumulateData {
	
	@Getter
	private List<String[]> unstructuredProductData;;
	private CSVReader reader;
	
	public AccumulateData(String fileName) {
		this.reader = getCSVReaderFromFileName(fileName);
		getDataFromCSVReader();
	}
	
	private void getDataFromCSVReader() {
		try {
			unstructuredProductData = reader.readAll();
			stringTrimmer();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void stringTrimmer() {
		for (String[] strings : unstructuredProductData) {
			for (int x = 0; x < strings.length; x++) {
				strings[x] = strings[x].trim();
			}
		}
			
	}
	
	private CSVReader getCSVReaderFromFileName(String fileName){
		CSVReader testReader = null;
		
		try {
			testReader = new CSVReader(new FileReader(fileName + ".txt"), ',' ,'"', 1);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return testReader;
	}

}
