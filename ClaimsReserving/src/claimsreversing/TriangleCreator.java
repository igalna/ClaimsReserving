package claimsreversing;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;

@AllArgsConstructor(staticName = "of")
public class TriangleCreator {

	private List<Product> inputData;
	
	
	public List<TriangleOfPaymentFigures> createTrianglesFromInputData() {
		//Map<String, Map<Integer, List<Product>>> result;
		//result = inputData.stream().collect(Collectors.groupingBy(Product::getProduct, Collectors.groupingBy(Product::getOriginYear)));
		//return result;
		
		List<TriangleOfPaymentFigures> triangleList = new ArrayList<TriangleOfPaymentFigures>();
	
		
		for (Product product : inputData) {
			if (triangleList.isEmpty()) {
				TriangleOfPaymentFigures newTriangle = TriangleOfPaymentFigures.of(product.getProduct(), product.getOriginYear(), new ArrayList<Product>());
				newTriangle.getListOfProductsInTriangle().add(product);
				triangleList.add(newTriangle);
			}
			else  {
				boolean flagTriangleAlreadyExists = false;
				for (TriangleOfPaymentFigures triangle : triangleList) {
					if (triangle.getProduct().equals(product.getProduct()) && triangle.getOriginYear().equals(product.getOriginYear())) {
						triangle.getListOfProductsInTriangle().add(product);
						flagTriangleAlreadyExists = true;
					}
				}
				if (flagTriangleAlreadyExists == false) {
					TriangleOfPaymentFigures newTriangle = TriangleOfPaymentFigures.of(product.getProduct(), product.getOriginYear(), new ArrayList<Product>());
					newTriangle.getListOfProductsInTriangle().add(product);
					triangleList.add(newTriangle);
				}
			}
			
		}
		return triangleList;
	}
	
}