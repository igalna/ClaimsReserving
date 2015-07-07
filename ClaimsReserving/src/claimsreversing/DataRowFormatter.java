package claimsreversing;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor(staticName = "of")
public class DataRowFormatter {

	@Getter
	private List<String[]> inputData;
	
	public List<Product> formatInputDataIntoStructuredProducts() {
		
		List<Product> result = new ArrayList<Product>();
		
		for (int x = 0; x < inputData.size(); x++) {
			for (int y = 0; y < inputData.get(x).length -1; y++) {
				String[] temp = inputData.get(x);
				Product newProduct = Product.of(temp[0], Integer.parseInt(temp[1]), Integer.parseInt(temp[2]), Double.parseDouble(temp[3]));
				result.add(newProduct);
			}
		}
		return result;
	}
}
