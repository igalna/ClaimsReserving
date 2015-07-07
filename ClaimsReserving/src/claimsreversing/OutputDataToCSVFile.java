package claimsreversing;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import com.opencsv.CSVWriter;

public class OutputDataToCSVFile {
	
	private Map<String, Map<Integer, List<Product>>> inputData;
	private CSVWriter writer;

	
	public OutputDataToCSVFile(String fileName, Map<String, Map<Integer, List<Product>>> inputData) {
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
		Collection<Map<Integer, List<Product>>> entries = inputData.values();
		
		entries.stream().min(Product::getOriginYear);
	}*/

}