package claimsreversing;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;

@AllArgsConstructor(staticName = "of")
public class TriangleCreator {

	private List<Product> inputData;
	
	public Map<String, Map<Integer, List<Product>>> createTrianglesFromInputData() {
		Map<String, Map<Integer, List<Product>>> result;
		
		result = inputData.stream().collect(Collectors.groupingBy(Product::getProduct, Collectors.groupingBy(Product::getOriginYear)));
		
		return result;
	}
	
}
