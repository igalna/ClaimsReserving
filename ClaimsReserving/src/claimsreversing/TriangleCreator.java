package claimsreversing;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import lombok.AllArgsConstructor;

@AllArgsConstructor(staticName = "of")
public class TriangleCreator {

	private List<Product> inputData;
	
	
	public List<Triangle> createTrianglesFromInputData() {
		//Map<String, Map<Integer, List<Product>>> result;
		//result = inputData.stream().collect(Collectors.groupingBy(Product::getProduct, Collectors.groupingBy(Product::getOriginYear)));
		//return result;
		
		List<Triangle> triangleList = new ArrayList<Triangle>();
	
		
		for (Iterator<Product> productIterator = inputData.iterator(); productIterator.hasNext(); ) {
			Product product = productIterator.next();
			if (triangleList.isEmpty()) {
				Triangle newTriangle = Triangle.of(product.getProduct(), product.getOriginYear(), new ArrayList<Product>());
				newTriangle.getListOfProductsInTriangle().add(product);
				triangleList.add(newTriangle);
			}
			else {
				for (Triangle triangle : triangleList) {
					if (triangle.getProduct().equals(product.getProduct()) && triangle.getOriginYear().equals(product.getOriginYear())) {
						triangle.getListOfProductsInTriangle().add(product);
					}
				}
				Triangle newTriangle = Triangle.of(product.getProduct(), product.getOriginYear(), new ArrayList<Product>());
				newTriangle.getListOfProductsInTriangle().add(product);
				triangleList.add(newTriangle);
			}
			
		}
		return triangleList;
	}
	
}