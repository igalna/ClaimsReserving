package claimsreversing;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor(staticName = "of")
public class DataRowFormatter {

	@Getter
	private List<String[]> inputData;
	
	public List<Product> dataFormatter() {
		List<Product> result = new ArrayList<Product>();
		for (int x = 0; x < inputData.size(); x++) {
			
		}
	}
}
