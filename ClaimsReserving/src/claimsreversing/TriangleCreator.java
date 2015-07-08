package claimsreversing;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;

@AllArgsConstructor(staticName = "of")
public class TriangleCreator {

	private List<Product> inputData;
	
	
	public List<TriangleOfPaymentFigures> createTrianglesFromInputData() {
		
		List<TriangleOfPaymentFigures> triangleList = new ArrayList<TriangleOfPaymentFigures>();
	
		for (Product product : inputData) {
			if (triangleList.isEmpty()) {
				TriangleOfPaymentFigures newTriangle = TriangleOfPaymentFigures.of(product.getProductName(), product.getOriginYear(), new ArrayList<Product>());
				newTriangle.getListOfProductsInTriangle().add(product);
				triangleList.add(newTriangle);
			}
			else  {
				boolean flagTriangleAlreadyExists = false;
				for (TriangleOfPaymentFigures triangle : triangleList) {
					if (triangle.getProductName().equals(product.getProductName()) && triangle.getOriginYear().equals(product.getOriginYear())) {
						triangle.getListOfProductsInTriangle().add(product);
						flagTriangleAlreadyExists = true;
					}
				}
				if (flagTriangleAlreadyExists == false) {
					TriangleOfPaymentFigures newTriangle = TriangleOfPaymentFigures.of(product.getProductName(), product.getOriginYear(), new ArrayList<Product>());
					newTriangle.getListOfProductsInTriangle().add(product);
					triangleList.add(newTriangle);
				}
			}
			
		}
		return triangleList;
	}
}